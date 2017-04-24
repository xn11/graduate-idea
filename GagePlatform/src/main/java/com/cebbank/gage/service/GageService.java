package com.cebbank.gage.service;

import com.cebbank.gage.model.Gage;
import com.cebbank.gage.model.Organization;
import com.cebbank.gage.model.Price;

import java.util.List;

/**
 * Created by xn on 2017/3/6.
 */
public interface GageService {
    public void saveList(List<Gage> list);

    public List<Gage> getAll();

    public Gage getById(int id);

    public void update(Gage gage);

    public void delete(int id);

    public void init();

    //price
    public double getLatestPrice(int id);

    public List<Price> getPrice(int id);

    public void savePrice(Price price);

    public void updatePrice(Price price);

    public void deletePrice(int id);
}
