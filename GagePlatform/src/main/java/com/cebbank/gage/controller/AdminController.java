package com.cebbank.gage.controller;

import com.cebbank.gage.common.GeneralResult;
import com.cebbank.gage.common.RoleEnum;
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

/**
 * Created by xn on 2017/3/28.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    private Logger logger = org.slf4j.LoggerFactory.getLogger("gage.file");

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public ModelAndView homeView(@ModelAttribute("user") User user, HttpServletRequest request) {
        request.getSession().setAttribute("user", user);
        return new ModelAndView("/admin/home", "user", user);
    }

    /*@RequestMapping(value = {"/userlist"}, method = RequestMethod.GET)
    public ModelAndView userlistView(HttpServletRequest request) throws IOException {
        GeneralResult<List<User>> result = userService.getAll();
        String view = "/admin/userlist";
        if (!result.isNormal()){
            return new ModelAndView(view, "msg", "暂无记录！");
        }
        return new ModelAndView(view, "userlist", result.getData());
    }*/

    @RequestMapping(value = {"/userlist"}, method = RequestMethod.GET)
    public String userlistView() {
        return "/admin/userlist";
    }

    @RequestMapping(value = {"/getUserListMap"})
    @ResponseBody
    public Map<String, Object> getUserListMap(HttpServletRequest request) {
        GeneralResult<List<User>> result = userService.getAll();
        List<User> data = result.getData();
        Map<String, Object> info = new HashMap<String, Object>();
        info.put("data", data);
        info.put("recordsTotal", data.size());
        return info;
    }

//    @RequestMapping(value = {"/delUsers"}, method = RequestMethod.POST)
//    @ResponseBody
//    public void delUsers(@RequestBody List<User> users) throws IOException {
//        System.out.println(users.size());
////        userService.delAll(users);
//    }

    @RequestMapping(value = {"/delUsers"}, method = RequestMethod.POST)
    @ResponseBody
    public GeneralResult delUsers(@RequestParam(value = "data[]") int[] ids, HttpServletRequest request) {
        logger.info(request.getSession().getAttribute("uid") + "," + "删除用户" + ids);
        return userService.delAll(ids);
    }

    @RequestMapping(value = {"/updateUser"}, method = RequestMethod.POST)
    @ResponseBody
    public GeneralResult updateUser(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        GeneralResult<User> result = userService.getById(id);
        if (result.isNormal()) {
            User user = result.getData();
            user.setPassword(request.getParameter("password"));
            user.setTelephone(request.getParameter("telephone"));
            user.setNote(request.getParameter("note"));
            user.setStatus(Integer.parseInt(request.getParameter("status")));
            user.setRole(RoleEnum.values()[Integer.parseInt(request.getParameter("role"))]);
            GeneralResult update = userService.update(user);

            //若更新为当前user则更新session中user
            HttpSession session = request.getSession();
            User currentUser = (User) session.getAttribute("user");
            if (id == currentUser.getId() && update.isNormal()) {
                session.setAttribute("user", user);
            }

            logger.info(session.getAttribute("uid") + "," + "更新用户" + user.getId());

            return update;
        } else {
            return result;
        }
    }

    @RequestMapping(value = {"/addUser"}, method = RequestMethod.POST)
    @ResponseBody
    public GeneralResult addUser(HttpServletRequest request) {
        int roleId = Integer.parseInt(request.getParameter("role"));
        String uname = "s";
        if (roleId == RoleEnum.REGULATORS.getId()) {
            uname = "r";
        }
        uname += request.getParameter("uid");
        String password = request.getParameter("password");
        String telephone = request.getParameter("telephone");
        String note = request.getParameter("note");
        User user = new User(uname, roleId, password, telephone, note);

        logger.info(request.getSession().getAttribute("uid") + "," + "添加用户name=" + uname);

        return userService.save(user);
    }

    @RequestMapping(value = "/accountInfo", method = RequestMethod.GET)
    public String accountInfoView() {
        return "/admin/accountInfo";
    }

    @RequestMapping(value = "/modifyPassword", method = RequestMethod.GET)
    public String modifyPassword() {
        return "/admin/modifyPassword";
    }

    /**
     * Regulators
     */
    @Autowired
    private RegulatorsService regulatorsService;

    @RequestMapping(value = {"/regulatorsList"}, method = RequestMethod.GET)
    public String regulatorsListView() {
        return "/admin/regulatorsList";
    }


    @RequestMapping(value = {"/getRegulatorsListMap"})
    @ResponseBody
    public Map<String, Object> getRegulatorsListMap() {
        GeneralResult<List<Regulators>> result = regulatorsService.getAll();
        List<Regulators> data = result.getData();
        Map<String, Object> info = new HashMap<String, Object>();
        info.put("data", data);
        info.put("recordsTotal", data.size());
        return info;
    }

    @RequestMapping(value = {"/delRegulators"}, method = RequestMethod.POST)
    @ResponseBody
    public GeneralResult delRegulators(@RequestParam(value = "data[]") int[] ids, HttpServletRequest request) {
        logger.info(request.getSession().getAttribute("uid") + "," + "删除监管机构" + ids);
        return regulatorsService.delAll(ids);
    }

    @RequestMapping(value = {"/updateRegulators"}, method = RequestMethod.POST)
    @ResponseBody
    public GeneralResult updateRegulators(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        GeneralResult<Regulators> result = regulatorsService.getById(id);
        if (result.isNormal()) {
            Regulators regulators = result.getData();
            regulators.setName(request.getParameter("name"));
            regulators.setAddress(request.getParameter("address"));
            regulators.setContact(request.getParameter("contact"));
            regulators.setTelephone(request.getParameter("telephone"));
            regulators.setEmail(request.getParameter("email"));
            regulators.setScore(Double.parseDouble(request.getParameter("score")));
            regulators.setNote(request.getParameter("note"));

            logger.info(request.getSession().getAttribute("uid") + "," + "更新监管机构" + id);
            return regulatorsService.update(regulators);
        } else {
            return result;
        }
    }

    @RequestMapping(value = {"/addRegulators"}, method = RequestMethod.POST)
    @ResponseBody
    public GeneralResult addRegulators(HttpServletRequest request) {
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String contact = request.getParameter("contact");
        String telephone = request.getParameter("telephone");
        String email = request.getParameter("email");
        String note = request.getParameter("note");
        Regulators regulators = new Regulators(name, address, contact, telephone, email, note);

        logger.info(request.getSession().getAttribute("uid") + "," + "添加监管机构name=" + name);
        return regulatorsService.save(regulators);
    }

    /**
     * Staff
     */
    @Autowired
    private StaffService staffService;

    @RequestMapping(value = {"/staffList"}, method = RequestMethod.GET)
    public String staffListView() {
        return "/admin/staffList";
    }


    @RequestMapping(value = {"/getStaffListMap"})
    @ResponseBody
    public Map<String, Object> getStaffListMap() {
        GeneralResult<List<Staff>> result = staffService.getAll();
        List<Staff> data = result.getData();
        Map<String, Object> info = new HashMap<String, Object>();
        info.put("data", data);
        info.put("recordsTotal", data.size());
        return info;
    }

    /**
     * Org
     */
    @Autowired
    private AdminService adminService;

    @RequestMapping(value = {"/organizationList"}, method = RequestMethod.GET)
    public String organizationListView() {
        return "/admin/organizationList";
    }


    @RequestMapping(value = {"/getRootOrgList"}, method = RequestMethod.POST)
    @ResponseBody
    public List<Organization> getRootOrgList() {
        GeneralResult<List<Organization>> result = adminService.getRootOrg();
        if (result.isNormal()) {
            return result.getData();
        }
        return null;
    }

    /*
     * warning
     */
    @RequestMapping(value = {"/receivedWarningList"}, method = RequestMethod.GET)
    public String receivedWarningListView() {
        return "/admin/receivedWarningList";
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

        return "/admin/sendWarningList";
    }

    @RequestMapping(value = {"/handleWarningList"}, method = RequestMethod.GET)
    public String handleWarningListView() {
        return "/admin/handleWarningList";
    }

    /**
     * company
     */
    @Autowired
    private CompanyService companyService;

}
