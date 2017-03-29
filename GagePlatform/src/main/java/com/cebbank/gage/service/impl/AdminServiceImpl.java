package com.cebbank.gage.service.impl;

import com.cebbank.gage.dao.ConfigDao;
import com.cebbank.gage.dao.OrganizationDao;
import com.cebbank.gage.model.Config;
import com.cebbank.gage.model.Organization;
import com.cebbank.gage.service.AdminService;
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
        configDao.save(config);
    }

    public List<Config> getAllConfig() {
        return configDao.getAll();
    }


    //org
    public void saveList(List<Organization> list) {
        for (Organization org: list) {
            organizationDao.save(org);
        }
    }

    public List<Organization> getAll() {
        return organizationDao.getAll();
    }

    public Organization getById(int id) {
        return organizationDao.getById(id);
    }

    public void update(Organization organization) {
        organizationDao.update(organization);
    }

    public void delete(int id) {
        organizationDao.delete(new Organization(id));
    }
}
