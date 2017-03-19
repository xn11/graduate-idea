package com.cebbank.gage.dao.impl;

import com.cebbank.gage.dao.*;
import com.cebbank.gage.model.*;
import org.springframework.stereotype.Repository;

/**
 * Created by xn on 2017/3/6.
 */
@Repository
public class OrganizationDaoImpl extends HibernateBaseDaoImpl<Organization> implements OrganizationDao {

    public OrganizationDaoImpl() {
        super(Organization.class);
    }
}
