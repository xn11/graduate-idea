package com.cebbank.gage.dao.impl;

import com.cebbank.gage.dao.BiddingDao;
import com.cebbank.gage.model.Bidding;
import org.springframework.stereotype.Repository;

/**
 * Created by xn on 2017/3/6.
 */
@Repository
public class BiddingDaoImpl extends HibernateBaseDaoImpl<Bidding> implements BiddingDao {

    public BiddingDaoImpl() {
        super(Bidding.class);
    }
}
