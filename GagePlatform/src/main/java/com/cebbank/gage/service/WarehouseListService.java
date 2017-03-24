package com.cebbank.gage.service;

import com.cebbank.gage.model.WarehouseList;

import java.util.List;

/**
 * Created by xn on 2017/3/6.
 */
public interface WarehouseListService {
    public void save(WarehouseList obj);

    public List<WarehouseList> getAll();

    public WarehouseList getById(int id);

    public void update(WarehouseList obj);

    public void delete(int id);
}
