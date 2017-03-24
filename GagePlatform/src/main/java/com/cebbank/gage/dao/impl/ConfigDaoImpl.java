package com.cebbank.gage.dao.impl;

import com.cebbank.gage.dao.ConfigDao;
import com.cebbank.gage.model.Config;
import org.springframework.stereotype.Repository;

/**
 * Created by xn on 2017/3/6.
 */
@Repository
public class ConfigDaoImpl extends HibernateBaseDaoImpl<Config> implements ConfigDao {

    public ConfigDaoImpl() {
        super(Config.class);
    }
}
