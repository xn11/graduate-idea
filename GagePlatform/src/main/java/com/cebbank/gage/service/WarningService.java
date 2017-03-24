package com.cebbank.gage.service;

import com.cebbank.gage.model.Warning;

import java.util.List;

/**
 * Created by xn on 2017/3/6.
 */
public interface WarningService {
    public void saveList(List<Warning> list);

    public List<Warning> getAll();

    public Warning getById(int id);

    public void update(Warning obj);

    public void delete(int id);
}
