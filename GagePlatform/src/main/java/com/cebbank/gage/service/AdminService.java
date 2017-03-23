package com.cebbank.gage.service;

import com.cebbank.gage.model.Config;

import java.util.List;

/**
 * Created by xn on 2017/3/6.
 */
public interface AdminService {

    public void saveConfig(Config config);

    public List<Config> getAllConfig();
}
