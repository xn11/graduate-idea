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
@RequestMapping("/user")
public class UserController {
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
        if (result.isNormal()){
            session.setAttribute("user", user);
        }

        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/modifyPassword", method = RequestMethod.POST)
    public GeneralResult modifyPasswordPost(HttpServletRequest request, HttpServletResponse response) {
        String newPwd = request.getParameter("newPwd");
        User user = (User) request.getSession().getAttribute("user");
        user.setPassword(newPwd);

        userService.update(user);
        return new GeneralResult();
    }

}
