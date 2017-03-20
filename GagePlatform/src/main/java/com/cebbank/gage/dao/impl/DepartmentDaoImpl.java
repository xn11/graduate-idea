package com.cebbank.gage.dao.impl;

import com.cebbank.gage.dao.DepartmentDao;
import com.cebbank.gage.dao.OrganizationDao;
import com.cebbank.gage.model.Department;
import com.cebbank.gage.model.Organization;
import org.springframework.stereotype.Repository;

/**
 * Created by xn on 2017/3/6.
 */
@Repository
public class DepartmentDaoImpl extends HibernateBaseDaoImpl<Department> implements DepartmentDao {

    public DepartmentDaoImpl() {
        super(Department.class);
    }
}
