package com.cebbank.gage.service.impl;

import com.cebbank.gage.dao.GageDao;
import com.cebbank.gage.dao.PriceDao;
import com.cebbank.gage.model.Gage;
import com.cebbank.gage.model.Price;
import com.cebbank.gage.service.GageService;
import com.cebbank.gage.util.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xn on 2017/3/6.
 */
@Service("gageService")
public class GageServiceImpl implements GageService {

    @Autowired
    private GageDao gageDao;
    @Autowired
    private PriceDao priceDao;


    public void saveList(List<Gage> list) {
        for (Gage obj : list) {
            gageDao.save(obj);
        }
    }

    public List<Gage> getAll() {
        return gageDao.getAll();
    }

    public Gage getById(int id) {
        return gageDao.getById(id);
    }

    public void update(Gage obj) {
        gageDao.update(obj);
    }

    public void delete(int id) {
        gageDao.delete(new Gage(id));
    }

    public double getLatestPrice(int id) {
        double res = -1;
        List<Price> list = getPrice(id);
        if (null != list && 0 != list.size()) {
            res = list.get(0).getPrice();
        }
        return res;
    }

    public List<Price> getPrice(int id) {
        String hql = "from Price where gage_id = :id order by timestamp desc";
        return priceDao.findList(hql, new Parameter(new Object[][]{{"id", id}}));
    }

    public void savePrice(Price price) {
        priceDao.save(price);
    }

    public void updatePrice(Price price) {
        priceDao.update(price);
    }

    public void deletePrice(int id) {
        priceDao.delete(new Price(id));
    }


}
