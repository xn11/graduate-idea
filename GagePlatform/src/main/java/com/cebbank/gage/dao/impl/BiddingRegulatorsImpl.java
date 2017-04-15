package com.cebbank.gage.dao.impl;

import com.cebbank.gage.dao.BiddingRegulatorsDao;
import com.cebbank.gage.model.BiddingRegulators;
import org.springframework.stereotype.Repository;

/**
 * Created by xn on 2017/3/6.
 */
@Repository
public class BiddingRegulatorsImpl extends HibernateBaseDaoImpl<BiddingRegulators> implements BiddingRegulatorsDao {

    public BiddingRegulatorsImpl() {
        super(BiddingRegulators.class);
    }
}
