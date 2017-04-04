package com.cebbank.gage.service.impl;

import com.cebbank.gage.dao.StaffDao;
import com.cebbank.gage.model.Staff;
import com.cebbank.gage.service.StaffService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xn on 2017/3/6.
 */
@Service("staffService")
public class StaffServiceImpl implements StaffService {
    private Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StaffDao dao;


    public void saveList(List<Staff> list) {
        try {
            for (Staff obj : list) {
                dao.save(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Staff> getAll() {
        return dao.getAll();
    }

    public Staff getById(int id) {
        return dao.getById(id);
    }

    public void update(Staff obj) {
        try {
            dao.update(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            dao.delete(new Staff(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
