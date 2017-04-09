package com.cebbank.gage.service;

import com.cebbank.gage.common.GeneralResult;
import com.cebbank.gage.model.Warning;

import java.util.List;

/**
 * Created by xn on 2017/3/6.
 */
public interface WarningService {
    public void saveList(List<Warning> list);

    public List<Warning> getAll();

    public GeneralResult<Warning> getById(int id);

    public GeneralResult update(Warning obj);

    public GeneralResult saveOrUpdate(Warning obj);

    public GeneralResult delete(int id);

    public GeneralResult delAll(int[] ids);
}
