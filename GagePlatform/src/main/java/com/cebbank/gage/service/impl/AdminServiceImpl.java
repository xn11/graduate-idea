package com.cebbank.gage.service.impl;

import com.cebbank.gage.common.GeneralResult;
import com.cebbank.gage.common.ResultEnum;
import com.cebbank.gage.dao.ConfigDao;
import com.cebbank.gage.dao.OrganizationDao;
import com.cebbank.gage.model.Config;
import com.cebbank.gage.model.Organization;
import com.cebbank.gage.service.AdminService;
import com.cebbank.gage.util.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xn on 2017/3/6.
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {

    @Autowired
    private ConfigDao configDao;
    @Autowired
    private OrganizationDao organizationDao;

    //config
    public void saveConfig(Config config) {
        try {
            configDao.save(config);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Config> getAllConfig() {
        return configDao.getAll();
    }

    public GeneralResult<List<Organization>> getRootOrg() {
        String hql = "from Organization where level=:level";
        List<Organization> rootList = organizationDao.findList(hql, new Parameter(new Object[][]{{"level", 0}}));
        GeneralResult<List<Organization>> result = new GeneralResult<List<Organization>>();
        if (rootList.isEmpty()) {
            result.setResultCode(ResultEnum.E_NOT_EXIST);
        }else {
            result.setData(rootList);
        }
        return result;
    }


    //org
    public void saveList(List<Organization> list) {
        try {
            for (Organization org : list) {
                organizationDao.save(org);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Organization> getAll() {
        return organizationDao.getAll();
    }

    public Organization getById(int id) {
        return organizationDao.getById(id);
    }

    public void update(Organization organization) {
        try {
            organizationDao.update(organization);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            organizationDao.delete(new Organization(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
