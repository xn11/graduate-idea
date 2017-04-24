package com.cebbank.gage.controller;

import com.cebbank.gage.common.GeneralResult;
import com.cebbank.gage.common.NoticeStatusTypeEnum;
import com.cebbank.gage.common.StatusTypeEnum;
import com.cebbank.gage.common.WarningTypeEnum;
import com.cebbank.gage.model.Company;
import com.cebbank.gage.model.Notice;
import com.cebbank.gage.model.User;
import com.cebbank.gage.model.Warning;
import com.cebbank.gage.service.CompanyService;
import com.cebbank.gage.service.NoticeService;
import com.cebbank.gage.service.UserService;
import com.cebbank.gage.service.WarningService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by xn on 2017/3/28.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private Logger logger = org.slf4j.LoggerFactory.getLogger("gage.file");


    @Autowired
    private UserService userService;

    /*@RequestMapping(value = {"/userlist"}, method = RequestMethod.GET)
    public ModelAndView userlistView(HttpServletRequest request) throws IOException {
        GeneralResult<List<User>> result = userService.getAll();
        String view = "/admin/userlist";
        if (!result.isNormal()){
            return new ModelAndView(view, "msg", "暂无记录！");
        }
        return new ModelAndView(view, "userlist", result.getData());
    }*/

    @RequestMapping(value = "/accountInfo", method = RequestMethod.POST)
    @ResponseBody
    public GeneralResult modifyInfo(HttpServletRequest request) {
        String telephone = request.getParameter("telephone");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        user.setTelephone(telephone);
        GeneralResult result = userService.update(user);
        if (result.isNormal()) {
            session.setAttribute("user", user);

            logger.info(user.getId() + "," + "修改个人信息");
        }

        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/modifyPassword", method = RequestMethod.POST)
    public GeneralResult modifyPasswordPost(HttpServletRequest request) {
        String newPwd = request.getParameter("newPwd");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        user.setPassword(newPwd);
        GeneralResult result = userService.update(user);
        if (result.isNormal()) {
            session.setAttribute("user", user);

            logger.info(user.getId() + "," + "修改密码");
        }

        return result;
    }

    @Autowired
    private WarningService warningService;

//    @RequestMapping(value = {"/delWarnings"}, method = RequestMethod.POST)
//    @ResponseBody
//    public GeneralResult delWarnings(@RequestParam(value = "data[]") int[] ids) {
//        return warningService.delAll(ids);
//    }

    @RequestMapping(value = {"/getReceivedWarningListMap"})
    @ResponseBody
    public Map<String, Object> getReceivedWarningListMap(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        GeneralResult<User> result = userService.getById(user.getId());
        user = result.getData();
        Set<Warning> data = user.getReceiveWarnings();
        Map<String, Object> info = new HashMap<String, Object>();
        info.put("data", data);
        info.put("recordsTotal", data.size());
        return info;
    }

    @RequestMapping(value = {"/acceptWarning"})
    @ResponseBody
    public GeneralResult acceptWarning(HttpServletRequest request, @RequestParam(value = "id") int warningId) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        GeneralResult<Warning> result = warningService.getById(warningId);
        if (result.isNormal()) {
            Warning warning = result.getData();
            warning.setHandler(user);
            warning.setStatus(StatusTypeEnum.IN_PROCESS);
            result = warningService.update(warning);
            if (result.isNormal()) {
                logger.info(user.getId() + "," + "接受预警" + warningId);

                return new GeneralResult();
            }
        }
        return result;
    }

    @RequestMapping(value = {"/getSendWarningListMap"})
    @ResponseBody
    public Map<String, Object> getSendWarningListMap(HttpServletRequest request) {
        HttpSession session = request.getSession();

        //获取send warning list
        User user = (User) session.getAttribute("user");
        GeneralResult<User> result = userService.getById(user.getId());
        user = result.getData();
        Set<Warning> data = user.getSendWarnings();
        Map<String, Object> info = new HashMap<String, Object>();
        info.put("data", data);
        info.put("recordsTotal", data.size());
        return info;
    }

    @RequestMapping(value = {"/getHandleWarningListMap"})
    @ResponseBody
    public Map<String, Object> getHandleWarningListMap(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        GeneralResult<User> result = userService.getById(user.getId());
        user = result.getData();
        Set<Warning> data = user.getHandleWarnings();
        Map<String, Object> info = new HashMap<String, Object>();
        info.put("data", data);
        info.put("recordsTotal", data.size());
        return info;
    }

    @Autowired
    private CompanyService companyService;

    @RequestMapping(value = {"/addWarning"}, method = RequestMethod.POST)
    @ResponseBody
    public GeneralResult addWarning(HttpServletRequest request, @RequestParam(value = "receivers[]") int[] ids) {
        HttpSession session = request.getSession();
        User sender = (User) session.getAttribute("user");
        int companyId = Integer.parseInt(request.getParameter("company"));
        Company company = companyService.getById(companyId);
        int type = Integer.parseInt(request.getParameter("type"));
        int severity = Integer.parseInt(request.getParameter("severity"));
        String note = request.getParameter("note");

        Warning warning = new Warning(company, WarningTypeEnum.values()[type], sender, severity, note);

        List<User> receivers = new ArrayList<User>();
        for (int id : ids) {
            if (0 == id) {
                receivers = userService.getValidAll().getData();
                break;
            }
            GeneralResult<User> result = userService.getById(id);
            if (result.isNormal()) {
                receivers.add(result.getData());
            }
        }

        warning.setReceivers(new HashSet<User>(receivers));

        logger.info(request.getSession().getAttribute("uid") + "," + "发送预警");

        return warningService.saveOrUpdate(warning);
    }

    @RequestMapping(value = {"/handleWarning"}, method = RequestMethod.POST)
    @ResponseBody
    public GeneralResult handleWarning(HttpServletRequest request, @RequestParam(value = "warningId") int warningId, @RequestParam(value = "note") String note, @RequestParam(value = "status") int status) {
        GeneralResult<Warning> result = warningService.getById(warningId);
        if (result.isNormal()) {
            Warning warning = result.getData();
            warning.setNote(note);
            warning.setStatus(StatusTypeEnum.values()[status]);

            logger.info(request.getSession().getAttribute("uid") + "," + "处理预警" + warningId);

            return warningService.update(warning);
        }
        return result;
    }

}
