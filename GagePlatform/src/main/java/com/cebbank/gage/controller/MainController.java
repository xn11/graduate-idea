package com.cebbank.gage.controller;

import com.cebbank.gage.common.RoleEnum;
import com.cebbank.gage.model.User;
import com.cebbank.gage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by xn on 2017/3/6.
 */
@Controller
//@RequestMapping("/")
public class MainController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String home() {
        List<User> us = new ArrayList<User>();
        User user = new User("try6", RoleEnum.MARKETING_DIRECTOR.getId(), "try6");
//        Date d = new Date();
//        User u=new User("b",1,"b","123",d,0,d,null,null);

//        us.add(u);
//        u.setName("33");
//        u.setPassword("33");
        us.add(user);
        userService.saveUsers(us);

//        us = userService.getAllUsernames();
//        System.out.println(us.size() + us.get(0).getName());

//        User u = userService.getById(28);
//        u.setTelephone("0000");
//        userService.update(u);
//        userService.delete(27);
//        System.out.println(userService.getById(28).getName());
//        System.out.println(userService.getById(27));
//        userService.saveUsers(us);

        return "index";
    }

//    @RequestMapping(value = { "/Error", "/error" }, method = RequestMethod.GET)
//    public ModelAndView error(HttpServletRequest request,
//                              HttpServletResponse response) {
//        return new ModelAndView("error", null);
//    }

    @RequestMapping("/json")
    @ResponseBody
    public List<User> json() {
        return userService.getAllUsernames();
    }

    //http://localhost:8080/gage/hello/?name=nnn
    @RequestMapping("/hello")
    public String hello(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

    @RequestMapping("/user")
    @ModelAttribute
    public User getUser() {
        return userService.getAllUsernames().get(1);
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {

            final SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");

            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                try {
                    Date date = sf.parse(text);
                    setValue(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
