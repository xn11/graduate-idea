package com.cebbank.gage.controller;

import com.cebbank.gage.common.RoleEnum;
import com.cebbank.gage.service.UserService;
import com.cebbank.gage.model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by xn on 2017/3/6.
 */
@Controller
//@RequestMapping("/")
public class MainController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String home(){
        List<User> us = new ArrayList<User>();
        User u = new User("we", RoleEnum.ADMIN.getId(), "wq");
//        Date d = new Date();
//        User u=new User("b",1,"b","123",d,0,d,null,null);

        us.add(u);
        u.setName("33");
        u.setPassword("33");
        us.add(u);
        userService.saveUsers(us);
        return "index";
    }

//    @RequestMapping(value = { "/Error", "/error" }, method = RequestMethod.GET)
//    public ModelAndView error(HttpServletRequest request,
//                              HttpServletResponse response) {
//        return new ModelAndView("error", null);
//    }

//    @RequestMapping("/json")
//    @ResponseBody
//    public List<User> json(){
//      return userService.getAllUsernames();
//    }

}
