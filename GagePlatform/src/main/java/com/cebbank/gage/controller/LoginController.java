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
    public String loginView() throws IOException {
        return "login";
    }

    @RequestMapping(value = {"/error", "*/error"})
    public String errorView() throws IOException {
        return "error";
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes)
            throws IOException, ServletException {
        HttpSession session = request.getSession();
        String view = "/login";


        String uid = request.getParameter("uid");
        String password = request.getParameter("password");
        if (GageUtils.isBlank(uid) || GageUtils.isBlank(password)) {
            return new ModelAndView(view, "error", "*  " + ResultEnum.E_INVALID_PARAMETER.getDesc());
        }

        uid = uid.trim();
        password = password.trim();

        //预填充
        Cookie myCookie = new Cookie("uid", URLEncoder.encode(uid, "utf-8"));
        response.addCookie(myCookie);

        GeneralResult<User> userResult = userService.getByIdAndPassword(uid, password);

        if (!userResult.isNormal()) {
            return new ModelAndView(view, "error", "*  该用户" + userResult.getResultCode().getDesc());
        }

        //若用户名和密码正确，则签退或按角色登录
        User user = userResult.getData();

        //签退,转发给logout
        String action = request.getParameter("action");
        if (action.equals("logout")) {
            session.setAttribute("user", user);
            session.setAttribute("error", "    签退成功！");
            return new ModelAndView("forward:/logout");
        } else if (user.getStatus() == 1) {
            return new ModelAndView(view, "error", "*  该用户已登录，请先签退！");
        }

        session.setAttribute("error", "");
        user.setStatus(1);
        userService.update(user);
        switch (user.getRole()) {
            case ADMIN:
                view = "/admin/home";
                break;
            case REGULATOR:
                view = "/regulator/home";
                break;
            case REGULATORS:
                view = "/regulators/home";
                break;
            case ACCOUNT_MANAGER:
                view = "/account_manager/home";
                break;
            case MARKETING_DIRECTOR:
                view = "/marketing_director/home";
                break;
//            case REGULATORS:
//                view = "regulators/home";
//                break;
            default:
                break;
        }


        session.setAttribute("uid",user.getName());
        GageUtils.saveRequest(session.getId(), user);
        redirectAttributes.addFlashAttribute("user", user);
//        redirectAttributes.addAttribute("user", user);
        return new ModelAndView(new RedirectView(view));
    }

    @RequestMapping(value = {"/logout", "*/logout"})
    public String logout(HttpServletRequest request, RedirectAttributes redirectAttributes)
            throws IOException {
        HttpSession session = request.getSession();
        String error = (String) session.getAttribute("error");
        //user更新登录状态
        User user = (User) session.getAttribute("user");
        if (null != user) {
            user.setStatus(0);
            userService.update(user);
        } else {
            error = "*  签退失败，请重新签退！";
        }

        //添加提示信息
        GageUtils.removeRequest(session.getId());
        redirectAttributes.addFlashAttribute("error", error);
        session.invalidate();
        return "redirect:/login";
    }
}
