package com.cebbank.gage.service.impl;

import com.cebbank.gage.dao.WarehouseListDao;
import com.cebbank.gage.model.WarehouseList;
import com.cebbank.gage.service.WarehouseListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xn on 2017/3/6.
 */
@Service("warehouseListService")
public class WarehouseListServiceImpl implements WarehouseListService {

    @Autowired
    private WarehouseListDao dao;


    public void save(WarehouseList obj) {
        try {
            dao.save(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<WarehouseList> getAll() {
        return dao.getAll();
    }

    public WarehouseList getById(int id) {
        return dao.getById(id);
    }

    public void update(WarehouseList obj) {
        try {
            dao.update(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            dao.delete(new WarehouseList(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
