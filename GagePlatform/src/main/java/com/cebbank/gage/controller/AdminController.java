package com.cebbank.gage.controller;

import com.cebbank.gage.common.GeneralResult;
import com.cebbank.gage.model.User;
import com.cebbank.gage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

//    @RequestMapping(value = {"/getUserList"}, method = RequestMethod.GET)
//    @ResponseBody
//    public List<User> getUserList(HttpServletRequest request) throws IOException {
//        GeneralResult<List<User>> result = userService.getAll();
//        return result.getData();
//    }

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
    public GeneralResult delUsers(@RequestParam(value = "data[]")  int[]  ids) {
        userService.delAll(ids);
        return new GeneralResult();
    }

    @RequestMapping(value = "/accountInfo", method = RequestMethod.GET)
    public ModelAndView accountInfoView(HttpServletRequest request) {

        return new ModelAndView("/admin/accountInfo", "user", request.getSession().getAttribute("user"));
    }

    @RequestMapping(value = "/modifyPassword", method = RequestMethod.GET)
    public ModelAndView modifyPassword(HttpServletRequest request) {
        return new ModelAndView("/admin/modifyPassword", "user", request.getSession().getAttribute("user"));
    }

    @ResponseBody
    @RequestMapping(value = "/modifyPassword", method = RequestMethod.POST)
    public GeneralResult<String> modifyPasswordPost(HttpServletRequest request, HttpServletResponse response) {
        String newPwd = request.getParameter("newPwd");
        User user = (User) request.getSession().getAttribute("user");
        user.setPassword(newPwd);

        userService.update(user);
        return new GeneralResult();
    }

}
