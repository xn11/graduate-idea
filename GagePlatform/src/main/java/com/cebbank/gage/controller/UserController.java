package com.cebbank.gage.controller;

import com.cebbank.gage.common.GeneralResult;
import com.cebbank.gage.common.RoleEnum;
import com.cebbank.gage.common.StatusTypeEnum;
import com.cebbank.gage.model.User;
import com.cebbank.gage.model.Warning;
import com.cebbank.gage.service.UserService;
import com.cebbank.gage.service.WarningService;
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
import java.util.Set;

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
    public GeneralResult modifyPasswordPost(HttpServletRequest request) {
        String newPwd = request.getParameter("newPwd");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        user.setPassword(newPwd);
        GeneralResult result = userService.update(user);
        if (result.isNormal()){
            session.setAttribute("user", user);
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
        User user = (User)session.getAttribute("user");
        GeneralResult<User> result = userService.getById(user.getId());
        user = result.getData();
        Set<Warning> data = user.getReceiveWarnings();
        Map<String, Object> info = new HashMap<String, Object>();
        info.put("data", data);
        info.put("recordsTotal", data.size());
        return info;
    }

    @RequestMapping(value = {"/handleWarning"})
    @ResponseBody
    public GeneralResult handleWarning(HttpServletRequest request, @RequestParam(value = "id") int warningId) {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");

        GeneralResult<Warning> result = warningService.getById(warningId);
        if (result.isNormal()) {
            Warning warning = result.getData();
            warning.setHandler(user);
            warning.setStatus(StatusTypeEnum.IN_PROCESS);
            result = warningService.update(warning);
            if (result.isNormal()) {
                return new GeneralResult();
            }
        }
        return result;
    }


}
