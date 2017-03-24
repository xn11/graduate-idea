package com.cebbank.gage.dao.impl;

import com.cebbank.gage.dao.GageDao;
import com.cebbank.gage.model.Gage;
import org.springframework.stereotype.Repository;

/**
 * Created by xn on 2017/3/6.
 */
@Repository
public class GageDaoImpl extends HibernateBaseDaoImpl<Gage> implements GageDao {

    public GageDaoImpl() {
        super(Gage.class);
    }
}
