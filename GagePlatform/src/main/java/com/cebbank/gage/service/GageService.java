package com.cebbank.gage.service;

import com.cebbank.gage.model.Gage;
import com.cebbank.gage.model.Organization;

import java.util.List;

/**
 * Created by xn on 2017/3/6.
 */
public interface GageService {
    public void saveList(List<Gage> list);

    public List<Gage> getAll();

    public Gage getById(int id);

    public void update(Gage organization);

    public void delete(int id);
}
