package com.cebbank.gage.controller;

import com.cebbank.gage.common.GeneralResult;
import com.cebbank.gage.model.User;
import com.cebbank.gage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * Created by xn on 2017/3/28.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public ModelAndView homeView(@ModelAttribute("user") User user , HttpServletRequest request) throws IOException {
        request.getSession().setAttribute("user", user);
        return new ModelAndView("admin/home", "user", user);
    }

    @RequestMapping(value = {"/userlist"}, method = RequestMethod.GET)
    public ModelAndView userlistView(HttpServletRequest request) throws IOException {
        GeneralResult<List<User>> result = userService.getAll();
        String view = "/admin/userlist";
        if (!result.isNormal()){
            return new ModelAndView(view, "msg", "暂无记录！");
        }
        return new ModelAndView(view, "userlist", result.getData());
    }

    @RequestMapping(value = "/accountInfo", method = RequestMethod.GET)
    public ModelAndView accountInfoView(HttpServletRequest request) {

        return new ModelAndView("/admin/accountInfo", "user", request.getSession().getAttribute("user"));
    }

    @RequestMapping(value = "/modifyPassword", method = RequestMethod.GET)
    public ModelAndView modifyPassword(HttpServletRequest request) {
        return new ModelAndView("/admin/modifyPassword", "user", request.getSession().getAttribute("user"));
    }

    @RequestMapping(value = "/modifyPassword", method = RequestMethod.POST)
    public void modifyPasswordPost(HttpServletRequest request) {

    }

}
