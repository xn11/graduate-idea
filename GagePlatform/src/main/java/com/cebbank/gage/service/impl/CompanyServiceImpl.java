package com.cebbank.gage.service.impl;

import com.cebbank.gage.dao.CompanyDao;
import com.cebbank.gage.dao.ConfigDao;
import com.cebbank.gage.model.Company;
import com.cebbank.gage.model.Config;
import com.cebbank.gage.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xn on 2017/3/6.
 */
@Service("companyService")
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyDao dao;
    @Autowired
    private ConfigDao configDao;


    public void saveList(List<Company> list) {
        for (Company obj: list) {
            dao.save(obj);
        }
    }

    public List<Company> getAll() {
        return dao.getAll();
    }

    public Company getById(int id) {
        return dao.getById(id);
    }

    public void update(Company obj) {
        dao.update(obj);
    }

    public void delete(int id) {
        dao.delete(new Company(id));
    }

    public void saveConfig(Config config) {
        configDao.save(config);
    }

    public List<Config> getAllConfig() {
        return configDao.getAll();
    }
}
