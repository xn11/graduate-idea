package com.cebbank.gage.controller;

import com.cebbank.gage.model.*;
import com.cebbank.gage.service.*;
import com.cebbank.gage.util.GageUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


/**
 * Created by xn on 2017/3/6.
 */
@Controller
@RequestMapping("/test")
public class TestController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

//    @Autowired
//    private OrganizationService organizationService;
    @Autowired
    private DepartmentService departmentService;
//    @Autowired
//    private CompanyService companyService;
//    @Autowired
//    private WarningService warningService;
//    @Autowired
//    private  UserService userService;
    @Autowired
    private  StaffService staffService;

    @RequestMapping("/")
    public String home() throws ParseException {
        List<Staff> list = new ArrayList<Staff>();
//        Department d = new Department("公司部", organizationService.getAll().get(0));
//        list.add(d);
//        d = new Department("公司部", organizationService.getAll().get(1));
//        list.add(d);

//        Company company = new Company("天武金属制造有限公司", 4, 0);
//        list.add(company);
//        company = new Company("景泰陶瓷加工厂", 4, 3);
//        list.add(company);

//        Config config = new Config("k", "v");
//        Company company = companyService.getAll().get(0);
//        User user = userService.getAllUsernames().get(0);
//
//        Warning warning = new Warning(company, 0, user, 0, 0, 1);
//        list.add(warning);
//        warningService.saveList(list);

        Staff staff = new Staff("齐思远", GageUtils.stringToDate("2015-06-05"), 14, "普通员工", departmentService.getAll().get(0));
        list.add(staff);
        staff = new Staff("钱天", 14, "普通员工", departmentService.getAll().get(0));
        list.add(staff);
        staffService.saveList(list);

//        Staff staff1 = staffService.getAll().get(0);
//        staff1.setIdCard("320211198001011209");
//        staffService.update(staff1);
//        logger.info("staff1: " + staff1.toString());

        logger.info("staff number: " + staffService.getAll().size());

        return "index";
    }

    @RequestMapping("/json")
    @ResponseBody
    public List<Staff> json() {
        return staffService.getAll();
    }



}
