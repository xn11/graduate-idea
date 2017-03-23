package com.cebbank.gage.dao.impl;

import com.cebbank.gage.dao.ContractDao;
import com.cebbank.gage.model.Contract;
import org.springframework.stereotype.Repository;

/**
 * Created by xn on 2017/3/6.
 */
@Repository
public class ContractDaoImpl extends HibernateBaseDaoImpl<Contract> implements ContractDao {

    public ContractDaoImpl() {
        super(Contract.class);
    }
}
