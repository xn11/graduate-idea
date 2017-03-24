package com.cebbank.gage.dao.impl;

import com.cebbank.gage.dao.RegulatorsDao;
import com.cebbank.gage.model.Regulators;
import org.springframework.stereotype.Repository;

/**
 * Created by xn on 2017/3/6.
 */
@Repository
public class RegulatorsDaoImpl extends HibernateBaseDaoImpl<Regulators> implements RegulatorsDao {

    public RegulatorsDaoImpl() {
        super(Regulators.class);
    }
}
