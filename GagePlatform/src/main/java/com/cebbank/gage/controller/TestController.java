package com.cebbank.gage.controller;

import com.cebbank.gage.model.*;
import com.cebbank.gage.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by xn on 2017/3/6.
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private OrganizationService organizationService;

    @RequestMapping("/")
    public String home() {
        List<Organization> list = new ArrayList<Organization>();
        Organization o = new Organization("总行", 0, null);
        list.add(o);
        Organization oo = new Organization("南京省行", 1, o);
        list.add(oo);
        organizationService.saveList(list);

        return "index";
    }

//    @RequestMapping(value = { "/Error", "/error" }, method = RequestMethod.GET)
//    public ModelAndView error(HttpServletRequest request,
//                              HttpServletResponse response) {
//        return new ModelAndView("error", null);
//    }

    @RequestMapping("/json")
    @ResponseBody
    public List<Organization> json() {
        return organizationService.getAll();
    }



}
