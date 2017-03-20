package com.cebbank.gage.dao.impl;

import com.cebbank.gage.dao.WarningDao;
import com.cebbank.gage.model.Warning;
import org.springframework.stereotype.Repository;

/**
 * Created by xn on 2017/3/6.
 */
@Repository
public class WarningDaoImpl extends HibernateBaseDaoImpl<Warning> implements WarningDao {

    public WarningDaoImpl() {
        super(Warning.class);
    }
}
