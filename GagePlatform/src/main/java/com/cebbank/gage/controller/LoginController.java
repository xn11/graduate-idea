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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * Created by xn on 2017/3/27.
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    public String loginView(HttpServletRequest request,
                            HttpServletResponse response) throws IOException {
        return "login";
    }

    @RequestMapping(value = {"/error"})
    public String errorView() throws IOException {
        return "error";
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes)
            throws IOException, ServletException {
        HttpSession session = request.getSession();
        String view = "login";


        String uid = request.getParameter("uid");
        String password = request.getParameter("password");
        if (GageUtils.isBlank(uid) || GageUtils.isBlank(password)) {
            return new ModelAndView(view, "error", "*  " + ResultEnum.E_INVALID_PARAMETER.getDesc());
        }

        uid = uid.trim();
        password = password.trim();

        GeneralResult<User> userResult = userService.getByIdAndPassword(uid, password);

        if (!userResult.isNormal()) {
            return new ModelAndView(view, "error", "*  该用户" + userResult.getResultCode().getDesc());
        }

        //若用户名和密码正确，则签退或按角色登录
        User user = userResult.getData();
        Cookie myCookie = new Cookie("uid", URLEncoder.encode(uid, "utf-8"));
        response.addCookie(myCookie);

        String action = request.getParameter("action");
        if (action.equals("logout")) {
            user.setStatus(0);
            userService.update(user);
            view = "logout";
            return new ModelAndView(new RedirectView(view));
        } else if (user.getStatus() == 1) {
            return new ModelAndView(view, "error", "*  该用户已登录，请先签退！");
        }

        session.setAttribute("error", "");
        user.setStatus(1);
        userService.update(user);
        switch (user.getRole()) {
            case ADMIN:
                view = "admin/home";
                break;
//            case REGULATORS:
//                view = "regulator/home";
//                break;
            default:
                break;
        }

        redirectAttributes.addFlashAttribute("user", user);
        return new ModelAndView(new RedirectView(view));
//        return new ModelAndView(view, "user", user);
    }

    @RequestMapping(value = {"/logout"})
    public String logout(HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes)
            throws IOException {
        request.getSession().invalidate();
        redirectAttributes.addFlashAttribute("error", "    签退成功！");
        return "redirect:/login";
    }
}
