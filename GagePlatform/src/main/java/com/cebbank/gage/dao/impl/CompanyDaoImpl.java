package com.cebbank.gage.dao.impl;

import com.cebbank.gage.dao.*;
import com.cebbank.gage.model.Company;
import org.springframework.stereotype.Repository;

/**
 * Created by xn on 2017/3/6.
 */
@Repository
public class CompanyDaoImpl extends HibernateBaseDaoImpl<Company> implements CompanyDao {

    public CompanyDaoImpl() {
        super(Company.class);
    }
}
