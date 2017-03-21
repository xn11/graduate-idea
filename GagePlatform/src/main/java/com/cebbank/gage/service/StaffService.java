package com.cebbank.gage.service;

import com.cebbank.gage.model.Staff;

import java.util.List;

/**
 * Created by xn on 2017/3/6.
 */
public interface StaffService {
    public void saveList(List<Staff> list);

    public List<Staff> getAll();

    public Staff getById(int id);

    public void update(Staff obj);

    public void delete(int id);
}
