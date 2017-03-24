package com.cebbank.gage.dao.impl;

import com.cebbank.gage.dao.ContractGageDao;
import com.cebbank.gage.model.ContractGage;
import org.springframework.stereotype.Repository;

/**
 * Created by xn on 2017/3/6.
 */
@Repository
public class ContractGageDaoImpl extends HibernateBaseDaoImpl<ContractGage> implements ContractGageDao {

    public ContractGageDaoImpl() {
        super(ContractGage.class);
    }
}
