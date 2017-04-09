package com.cebbank.gage.service;

import com.cebbank.gage.common.GeneralResult;
import com.cebbank.gage.model.Config;
import com.cebbank.gage.model.Organization;

import java.util.List;

/**
 * Created by xn on 2017/3/6.
 */
public interface AdminService {

    //config
    public void saveConfig(Config config);

    public List<Config> getAllConfig();

    //org
    public GeneralResult<List<Organization>> getRootOrg();

    public void saveList(List<Organization> list);

    public List<Organization> getAll();

    public Organization getById(int id);

    public void update(Organization organization);

    public void delete(int id);
}
