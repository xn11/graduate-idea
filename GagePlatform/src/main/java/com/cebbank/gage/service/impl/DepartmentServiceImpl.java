package com.cebbank.gage.service.impl;

import com.cebbank.gage.dao.*;
import com.cebbank.gage.model.*;
import com.cebbank.gage.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xn on 2017/3/6.
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao dao;


    public void saveList(List<Department> list) {
        for (Department obj: list) {
            dao.save(obj);
        }
    }

    public List<Department> getAll() {
        return dao.getAll();
    }

    public Department getById(int id) {
        return dao.getById(id);
    }

    public void update(Department obj) {
        dao.update(obj);
    }

    public void delete(int id) {
        dao.delete(new Department(id));
    }
}
