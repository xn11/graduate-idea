package com.cebbank.gage.service.impl;

import com.cebbank.gage.common.GeneralResult;
import com.cebbank.gage.common.ResultEnum;
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
        try {
            for (Warning obj : list) {
                dao.save(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Warning> getAll() {
        return dao.getAll();
    }

    public GeneralResult<Warning> getById(int id) {
        Warning warning = dao.getById(id);
        GeneralResult<Warning> result = new GeneralResult<Warning>();
        if (null != warning) {
            result.setData(warning);
        } else {
            result.setResultCode(ResultEnum.E_NOT_EXIST);
        }
        return result;
    }

    public GeneralResult update(Warning obj) {
        try {
            dao.update(obj);
        } catch (Exception e) {
            return new GeneralResult(ResultEnum.E_DATABASE_UPDATE);
        }
        return new GeneralResult();
    }

    public GeneralResult saveOrUpdate(Warning obj) {
        try {
            dao.saveOrUpdate(obj);
        } catch (Exception e) {
            return new GeneralResult(ResultEnum.E_DATABASE_UPDATE);
        }
        return new GeneralResult();
    }

    public GeneralResult delete(int id) {
        try {
            dao.delete(new Warning(id));
        } catch (Exception e) {
            return new GeneralResult(ResultEnum.E_DATABASE_DELETE);
        }
        return new GeneralResult();
    }

    public GeneralResult delAll(int[] ids) {
        try {
            for (int id : ids) {
                dao.delete(new Warning(id));
            }
        } catch (Exception e) {
            return new GeneralResult(ResultEnum.E_DATABASE_DELETE);
        }
        return new GeneralResult();
    }
}
