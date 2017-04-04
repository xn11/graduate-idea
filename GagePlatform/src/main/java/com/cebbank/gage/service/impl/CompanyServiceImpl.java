package com.cebbank.gage.service.impl;

import com.cebbank.gage.dao.CompanyDao;
import com.cebbank.gage.model.Company;
import com.cebbank.gage.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xn on 2017/3/6.
 */
@Service("companyService")
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyDao dao;


    public void saveList(List<Company> list) {
        try {
            for (Company obj : list) {
                dao.save(obj);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Company> getAll() {
        return dao.getAll();
    }

    public Company getById(int id) {
        return dao.getById(id);
    }

    public void update(Company obj) {
        try {
            dao.update(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            dao.delete(new Company(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
