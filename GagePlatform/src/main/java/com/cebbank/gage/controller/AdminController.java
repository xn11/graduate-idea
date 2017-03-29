package com.cebbank.gage.controller;

import com.cebbank.gage.common.GeneralResult;
import com.cebbank.gage.common.ResultEnum;
import com.cebbank.gage.model.User;
import com.cebbank.gage.service.UserService;
import com.cebbank.gage.util.GageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * Created by xn on 2017/3/28.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String loginView(HttpServletRequest request,
                            HttpServletResponse response) throws IOException {
        return "admin/home";
    }


}
