package com.cebbank.gage.service.impl;

import com.cebbank.gage.dao.ConfigDao;
import com.cebbank.gage.model.Config;
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


    public void saveConfig(Config config) {
        configDao.save(config);
    }

    public List<Config> getAllConfig() {
        return configDao.getAll();
    }
}
