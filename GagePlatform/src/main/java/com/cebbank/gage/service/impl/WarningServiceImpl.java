package com.cebbank.gage.service.impl;

import com.cebbank.gage.dao.WarningDao;
import com.cebbank.gage.model.Warning;
import com.cebbank.gage.service.WarningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xn on 2017/3/6.
 */
@Service("warningService")
public class WarningServiceImpl implements WarningService {

    @Autowired
    private WarningDao dao;


    public void saveList(List<Warning> list) {
        for (Warning obj: list) {
            dao.save(obj);
        }
    }

    public List<Warning> getAll() {
        return dao.getAll();
    }

    public Warning getById(int id) {
        return dao.getById(id);
    }

    public void update(Warning obj) {
        dao.update(obj);
    }

    public void delete(int id) {
        dao.delete(new Warning(id));
    }
}
