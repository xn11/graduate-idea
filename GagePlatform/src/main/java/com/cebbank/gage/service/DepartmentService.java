package com.cebbank.gage.service;

import com.cebbank.gage.model.Department;
import com.cebbank.gage.model.Organization;

import java.util.List;

/**
 * Created by xn on 2017/3/6.
 */
public interface DepartmentService {
    public void saveList(List<Department> list);

    public List<Department> getAll();

    public Department getById(int id);

    public void update(Department obj);

    public void delete(int id);
}
