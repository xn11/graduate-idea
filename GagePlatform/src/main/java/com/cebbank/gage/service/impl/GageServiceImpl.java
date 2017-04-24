package com.cebbank.gage.service.impl;

import com.cebbank.gage.dao.GageDao;
import com.cebbank.gage.dao.MysteelDao;
import com.cebbank.gage.dao.PriceDao;
import com.cebbank.gage.model.Gage;
import com.cebbank.gage.model.Mysteel;
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
    @Autowired
    private MysteelDao mysteelDao;


    public void saveList(List<Gage> list) {
        try {
            for (Gage obj : list) {
                gageDao.save(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Gage> getAll() {
        return gageDao.getAll();
    }

    public Gage getById(int id) {
        return gageDao.getById(id);
    }

    public void update(Gage obj) {
        try {
            gageDao.update(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            gageDao.delete(new Gage(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void init() {
        List<Mysteel> mysteelList = mysteelDao.getAll();
        for (Mysteel m:mysteelList) {
            /*Gage gage = new Gage(m.getName(),0,0.7,0.75,0.8);
            try {
                gageDao.saveOrUpdate(gage);
            } catch (Exception e) {
                e.printStackTrace();
            }*/
        }
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
        try {
            priceDao.save(price);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updatePrice(Price price) {
        try {
            priceDao.update(price);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletePrice(int id) {
        try {
            priceDao.delete(new Price(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
