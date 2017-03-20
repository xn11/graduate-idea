package com.cebbank.gage.controller;

import com.cebbank.gage.model.*;
import com.cebbank.gage.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by xn on 2017/3/6.
 */
@Controller
@RequestMapping("/test")
public class TestController {

//    @Autowired
//    private OrganizationService organizationService;
//    @Autowired
//    private DepartmentService departmentService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private WarningService warningService;
    @Autowired
    private  UserService userService;

    @RequestMapping("/")
    public String home() {
        List<Warning> list = new ArrayList<Warning>();
//        Department d = new Department("公司部", organizationService.getAll().get(0));
//        list.add(d);
//        d = new Department("公司部", organizationService.getAll().get(1));
//        list.add(d);

//        Company company = new Company("天武金属制造有限公司", 4, 0);
//        list.add(company);
//        company = new Company("景泰陶瓷加工厂", 4, 3);
//        list.add(company);

//        Config config = new Config("k", "v");
        Company company = companyService.getAll().get(0);
        User user = userService.getAllUsernames().get(0);

        Warning warning = new Warning(company, 0, user, 0, 0, 1);
        list.add(warning);
        warningService.saveList(list);

        return "index";
    }

    @RequestMapping("/json")
    @ResponseBody
    public List<Warning> json() {
        return warningService.getAll();
    }



}
