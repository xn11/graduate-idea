package com.cebbank.gage.service;

import com.cebbank.gage.common.GeneralResult;
import com.cebbank.gage.model.Staff;

import java.util.List;

/**
 * Created by xn on 2017/3/6.
 */
public interface StaffService {
//    public void saveList(List<Staff> list);

    public GeneralResult<List<Staff>> getAll();

    public GeneralResult<Staff> getById(int id);

    public GeneralResult<Staff> getDirector(int id);

    public GeneralResult<Staff> getByUid(String uid);

//    public void update(Staff obj);

//    public void delete(int id);
}
