package com.cebbank.gage.controller;

import com.cebbank.gage.model.*;
import com.cebbank.gage.service.*;
import com.cebbank.gage.util.GageUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
//    @Autowired
//    private DepartmentService departmentService;
    @Autowired
    private CompanyService companyService;
//    @Autowired
//    private WarningService warningService;
//    @Autowired
//    private  UserService userService;
    @Autowired
    private  StaffService staffService;
//    @Autowired
//    private GageService gageService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private ContractService contractService;

    @RequestMapping("/")
    public String home() throws ParseException {
//        List<Gage> list = new ArrayList<Gage>();
//        Department d = new Department("公司部", organizationService.getAll().get(0));
//        list.add(d);
//        d = new Department("公司部", organizationService.getAll().get(1));
//        list.add(d);

//        Company company = new Company("天武金属制造有限公司", 4, 0);
//        list.add(company);
//        company = new Company("景泰陶瓷加工厂", 4, 3);
//        list.add(company);

        Config config = new Config("k", "v");
        adminService.saveConfig(config);
//        Company company = companyService.getAll().get(0);
//        User user = userService.getAllUsernames().get(0);
//
//        Warning warning = new Warning(company, 0, user, 0, 0, 1);
//        list.add(warning);
//        warningService.saveList(list);

//        Staff staff = new Staff("齐思远", GageUtils.stringToDate("2015-06-05"), 14, "普通员工", departmentService.getAll().get(0));
//        list.add(staff);
//        staff = new Staff("钱天", 14, "普通员工", departmentService.getAll().get(0));
//        list.add(staff);

//        Gage gage = new Gage("普钢", 0, 0.6, 0.8, 0.9);
//        list.add(gage);

//        gageService.savePrice(new Price(gageService.getById(1), 111.2, "元/吨", "http://index.mysteel.com/xpic/detail.ms?tabName=tegang"));
//        gageService.saveList(list);

//        Staff staff1 = staffService.getAll().get(0);
//        staff1.setIdCard("320211198001011209");
//        staffService.update(staff1);


        Contract contract= new Contract(1170300001, 0, companyService.getById(1), staffService.getById(2010060000), staffService.getById(2015060002), GageUtils.stringToDate("2016-06-28"), GageUtils.stringToDate("2017-06-28"), 10000000.00,0);
        contractService.save(contract);

        return "index";
    }

    @RequestMapping("/json")
    @ResponseBody
    public Set<Contract> json() {
        return staffService.getById(2010060000).getContracts();
    }


}
