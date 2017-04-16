package com.cebbank.gage.controller;

import com.cebbank.gage.common.ContractStatusTypeEnum;
import com.cebbank.gage.common.GeneralResult;
import com.cebbank.gage.common.NoticeTypeEnum;
import com.cebbank.gage.model.*;
import com.cebbank.gage.service.*;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by xn on 2017/3/28.
 */
@Controller
@RequestMapping("/account_manager")
public class AccountManagerController {
    private Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public ModelAndView homeView(@ModelAttribute("user") User user, HttpServletRequest request) {
        request.getSession().setAttribute("user", user);
        request.getSession().setAttribute("uid", user.getName());
        return new ModelAndView("account_manager/home", "user", user);
    }

    @RequestMapping(value = "/accountInfo", method = RequestMethod.GET)
    public String accountInfoView() {
        return "/account_manager/accountInfo";
    }

    @RequestMapping(value = "/modifyPassword", method = RequestMethod.GET)
    public String modifyPassword() {
        return "/account_manager/modifyPassword";
    }

    /*
     * warning
     */
    @RequestMapping(value = {"/receivedWarningList"}, method = RequestMethod.GET)
    public String receivedWarningListView() {
        return "/account_manager/receivedWarningList";
    }

    @RequestMapping(value = {"/sendWarningList"}, method = RequestMethod.GET)
    public String sendWarningListView(HttpServletRequest request) {
        HttpSession session = request.getSession();

        //companyList放入session
        @SuppressWarnings("unchecked")
        List<Company> companyList = (List<Company>) session.getAttribute("companyList");
        if (null == companyList) {
            GeneralResult<List<Company>> result = companyService.getAll();
            if (result.isNormal()) {
                request.getSession().setAttribute("companyList", result.getData());
            }
        }

        //userList放入session
        @SuppressWarnings("unchecked")
        List<User> userList = (List<User>) session.getAttribute("userList");

        if (null == userList) {
            GeneralResult<List<User>> result = userService.getAll();
            if (result.isNormal()) {
                request.getSession().setAttribute("userList", result.getData());
            }
        }

        return "/account_manager/sendWarningList";
    }

    @RequestMapping(value = {"/handleWarningList"}, method = RequestMethod.GET)
    public String handleWarningListView() {
        return "/account_manager/handleWarningList";
    }

    /**
     * company
     */
    @Autowired
    private CompanyService companyService;

    /**
     * contract
     */
    @Autowired
    private ContractService contractService;
    @Autowired
    private StaffService staffService;
    @Autowired
    private NoticeService noticeService;

    @RequestMapping(value = "/contractList", method = RequestMethod.GET)
    public String contractListView() {
        return "/account_manager/contractList";
    }

    @RequestMapping(value = {"/getContractListMap"})
    @ResponseBody
    public Map<String, Object> getContractListMap(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        GeneralResult<Staff> result = staffService.getByUid(user.getName());

        Set<Contract> data = result.getData().getContracts();
        Map<String, Object> info = new HashMap<String, Object>();
        info.put("data", data);
        info.put("recordsTotal", data.size());
        return info;
    }

    @RequestMapping(value = {"/updateContract"}, method = RequestMethod.POST)
    @ResponseBody
    public GeneralResult updateContract(HttpServletRequest request, @RequestParam(value = "id") int id, @RequestParam(value = "note") String note) {
        GeneralResult<Contract> result = contractService.getById(id);
        if (result.isNormal()) {
            Contract contract = result.getData();
            if (contract.getNote().equals(note.trim())) {
                return result;
            }
            contract.setNote(note);
            GeneralResult updateResult = contractService.update(contract);

            if (updateResult.isNormal()) {
                logger.info(request.getSession().getAttribute("uid") + "," + "更新合同" + id);

            }

            return updateResult;
        } else {
            return result;
        }
    }

    @RequestMapping(value = {"/storageContract"}, method = RequestMethod.POST)
    @ResponseBody
    public GeneralResult storageContract(HttpServletRequest request, @RequestParam(value = "id") int id, @RequestParam(value = "note") String note) {
        GeneralResult<Contract> result = contractService.getById(id);
        if (result.isNormal()) {
            Contract contract = result.getData();

            //获取审批人
            User directorUser = null;
            GeneralResult<User> userResult = null;
            String directorUid = (String) request.getParameter("direvtor_uid");
            if (null != directorUid || !directorUid.equals("")) {
                userResult = userService.getByUid(directorUid);
                if (userResult.isNormal()) {
                    directorUser = userResult.getData();
                }
            }
            if (null == directorUser) {
                Staff staff = staffService.getByUid((String) request.getSession().getAttribute("uid")).getData();
                GeneralResult<Staff> staffResult = staffService.getDirector(staff.getId());
                if (staffResult.isNormal()) {
                    Staff director = staffResult.getData();
                    userResult = userService.getByUid("s" + director.getId());
                    if (userResult.isNormal()) {
                        directorUser = userResult.getData();
                    }
                }
            }
            if (null == directorUser) {
                userResult.setMessage("找不到部门主任，无法提交审批申请！");
                return userResult;
            }

            Company company = contract.getCompany();
            Notice notice = null;
            //如企业从未有业务则出质流程，否则变更质押物流程
            if (null == company.getBidding()) {
                //出质
                notice = new Notice(NoticeTypeEnum.PLEDGE_START, contract, directorUser);
            } else {
                //变更质押物
                notice = new Notice(NoticeTypeEnum.PLEDGE_CHANGE, contract, directorUser);
                Set<ContractGage> contractGages = contract.getContractGages();
                Set<NoticeGage> noticeGages = notice.getGages();
                for (ContractGage cg : contractGages) {
                    noticeGages.add(new NoticeGage(notice, cg.getGage(), cg.getQuantity()));
                }
            }

            GeneralResult<Integer> saveResult = noticeService.save(notice);
            if (saveResult.isNormal()) {
                contract.setStatus(ContractStatusTypeEnum.APPROVAL_PENDING);
            }

            //若变动了note则更新合同信息
            if (null != note && !note.trim().equals(contract.getNote())) {
                contract.setNote(note);
            }

            GeneralResult updateResult = contractService.update(contract);
            if (updateResult.isNormal()) {
                logger.info(request.getSession().getAttribute("uid") + "," + "更新合同" + id);

            }

            return updateResult;
        } else {
            return result;
        }
    }

}
