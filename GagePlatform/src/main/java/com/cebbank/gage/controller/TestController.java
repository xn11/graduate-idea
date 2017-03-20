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

    @RequestMapping("/")
    public String home() {
        List<Company> list = new ArrayList<Company>();
//        Department d = new Department("公司部", organizationService.getAll().get(0));
//        list.add(d);
//        d = new Department("公司部", organizationService.getAll().get(1));
//        list.add(d);
        Company company = new Company("天武金属制造有限公司", 4, 0);
        list.add(company);
        company = new Company("景泰陶瓷加工厂", 4, 3);
        list.add(company);
        companyService.saveList(list);

        return "index";
    }

    @RequestMapping("/json")
    @ResponseBody
    public List<Company> json() {
        return companyService.getAll();
    }



}
