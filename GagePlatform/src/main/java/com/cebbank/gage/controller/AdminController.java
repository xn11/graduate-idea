package com.cebbank.gage.controller;

import com.cebbank.gage.common.GeneralResult;
import com.cebbank.gage.common.RoleEnum;
import com.cebbank.gage.model.User;
import com.cebbank.gage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public ModelAndView homeView(@ModelAttribute("user") User user, HttpServletRequest request) {
        request.getSession().setAttribute("user", user);
        return new ModelAndView("admin/home", "user", user);
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
    public Map<String, Object> getUserListMap() {
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
    public GeneralResult delUsers(@RequestParam(value = "data[]") int[] ids) {
        return userService.delAll(ids);
    }

    @RequestMapping(value = {"/updateUser"}, method = RequestMethod.POST)
    @ResponseBody
    public GeneralResult updateUser(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        GeneralResult<User> result = userService.getById(id);
        if (result.isNormal()){
            User user = result.getData();
            user.setPassword(request.getParameter("password"));
            user.setTelephone(request.getParameter("telephone"));
            user.setNote(request.getParameter("note"));
            user.setStatus(Integer.parseInt(request.getParameter("status")));
            user.setRole(RoleEnum.values()[Integer.parseInt(request.getParameter("role"))]);
            return userService.update(user);
        }else{
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
        return userService.save(user);
    }

    @RequestMapping(value = "/accountInfo", method = RequestMethod.GET)
    public String accountInfoView() {
        return "/admin/accountInfo";
    }

    /*@RequestMapping(value = "/accountInfo", method = RequestMethod.POST)
    @ResponseBody
    public GeneralResult modifyInfo(HttpServletRequest request) {
        String telephone = request.getParameter("telephone");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        user.setTelephone(telephone);
        GeneralResult result = userService.update(user);
        if (result.isNormal()){
            session.setAttribute("user", user);
        }

        return result;
    }*/

    @RequestMapping(value = "/modifyPassword", method = RequestMethod.GET)
    public String modifyPassword() {
        return "/admin/modifyPassword";
    }

    /*@ResponseBody
    @RequestMapping(value = "/modifyPassword", method = RequestMethod.POST)
    public GeneralResult modifyPasswordPost(HttpServletRequest request, HttpServletResponse response) {
        String newPwd = request.getParameter("newPwd");
        User user = (User) request.getSession().getAttribute("user");
        user.setPassword(newPwd);

        userService.update(user);
        return new GeneralResult();
    }*/

}
