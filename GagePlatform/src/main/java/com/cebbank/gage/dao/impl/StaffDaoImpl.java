package com.cebbank.gage.dao.impl;

import com.cebbank.gage.dao.StaffDao;
import com.cebbank.gage.model.Staff;
import org.springframework.stereotype.Repository;

/**
 * Created by xn on 2017/3/6.
 */
@Repository
public class StaffDaoImpl extends HibernateBaseDaoImpl<Staff> implements StaffDao {

    public StaffDaoImpl() {
        super(Staff.class);
    }
}
