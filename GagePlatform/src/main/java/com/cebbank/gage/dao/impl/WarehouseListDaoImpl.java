package com.cebbank.gage.dao.impl;

import com.cebbank.gage.dao.WarehouseListDao;
import com.cebbank.gage.model.WarehouseList;
import org.springframework.stereotype.Repository;

/**
 * Created by xn on 2017/3/6.
 */
@Repository
public class WarehouseListDaoImpl extends HibernateBaseDaoImpl<WarehouseList> implements WarehouseListDao {

    public WarehouseListDaoImpl() {
        super(WarehouseList.class);
    }
}
