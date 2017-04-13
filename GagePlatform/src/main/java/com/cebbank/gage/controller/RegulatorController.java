package com.cebbank.gage.controller;

import com.cebbank.gage.common.GeneralResult;
import com.cebbank.gage.model.Company;
import com.cebbank.gage.model.User;
import com.cebbank.gage.service.CompanyService;
import com.cebbank.gage.service.UserService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by xn on 2017/3/28.
 */
@Controller
@RequestMapping("/regulator")
public class RegulatorController {
    private Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public ModelAndView homeView(@ModelAttribute("user") User user, HttpServletRequest request) {
        request.getSession().setAttribute("user", user);
        return new ModelAndView("regulator/home", "user", user);
    }

    @RequestMapping(value = "/accountInfo", method = RequestMethod.GET)
    public String accountInfoView() {
        return "/regulator/accountInfo";
    }

    @RequestMapping(value = "/modifyPassword", method = RequestMethod.GET)
    public String modifyPassword() {
        return "/regulator/modifyPassword";
    }

    /*
     * warning
     */
    @RequestMapping(value = {"/receivedWarningList"}, method = RequestMethod.GET)
    public String receivedWarningListView() {
        return "/regulator/receivedWarningList";
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

        return "/regulator/sendWarningList";
    }

    @RequestMapping(value = {"/handleWarningList"}, method = RequestMethod.GET)
    public String handleWarningListView() {
        return "/regulator/handleWarningList";
    }

    /**
     * company
     */
    @Autowired
    private CompanyService companyService;

}
