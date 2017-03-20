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

    @Autowired
    private OrganizationService organizationService;
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/")
    public String home() {
        List<Department> list = new ArrayList<Department>();
        Department d = new Department("公司部", organizationService.getAll().get(0));
        list.add(d);
        d = new Department("公司部", organizationService.getAll().get(1));
        list.add(d);
        departmentService.saveList(list);

        return "index";
    }

    @RequestMapping("/json")
    @ResponseBody
    public List<Department> json() {
        return departmentService.getAll();
    }



}
