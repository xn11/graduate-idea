package com.cebbank.gage.service.impl;

import com.cebbank.gage.dao.GageDao;
import com.cebbank.gage.model.Gage;
import com.cebbank.gage.service.GageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xn on 2017/3/6.
 */
@Service("gageService")
public class GageServiceImpl implements GageService {

    @Autowired
    private GageDao dao;


    public void saveList(List<Gage> list) {
        for (Gage obj: list) {
            dao.save(obj);
        }
    }

    public List<Gage> getAll() {
        return dao.getAll();
    }

    public Gage getById(int id) {
        return dao.getById(id);
    }

    public void update(Gage obj) {
        dao.update(obj);
    }

    public void delete(int id) {
        dao.delete(new Gage(id));
    }
}
