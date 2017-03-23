package com.cebbank.gage.dao.impl;

import com.cebbank.gage.dao.PriceDao;
import com.cebbank.gage.model.Price;
import org.springframework.stereotype.Repository;

/**
 * Created by xn on 2017/3/6.
 */
@Repository
public class PriceDaoImpl extends HibernateBaseDaoImpl<Price> implements PriceDao {

    public PriceDaoImpl() {
        super(Price.class);
    }
}
