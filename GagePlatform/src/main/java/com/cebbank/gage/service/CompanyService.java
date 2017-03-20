package com.cebbank.gage.service;

import com.cebbank.gage.model.Company;
import java.util.List;

/**
 * Created by xn on 2017/3/6.
 */
public interface CompanyService {
    public void saveList(List<Company> list);

    public List<Company> getAll();

    public Company getById(int id);

    public void update(Company obj);

    public void delete(int id);
}
