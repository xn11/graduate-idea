package com.cebbank.gage.service.impl;

import com.cebbank.gage.common.GeneralResult;
import com.cebbank.gage.common.ResultEnum;
import com.cebbank.gage.dao.RegulateAccountDao;
import com.cebbank.gage.dao.RegulatorsCompanyDao;
import com.cebbank.gage.dao.RegulatorsDao;
import com.cebbank.gage.model.RegulateAccount;
import com.cebbank.gage.model.Regulators;
import com.cebbank.gage.model.RegulatorsCompany;
import com.cebbank.gage.service.RegulatorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xn on 2017/3/6.
 */
@Service("regulatorsService")
public class RegulatorsServiceImpl implements RegulatorsService {

    @Autowired
    private RegulatorsDao dao;
    @Autowired
    private RegulatorsCompanyDao regulatorsCompanyDao;
    @Autowired
    private RegulateAccountDao regulateAccountDao;


    public GeneralResult<Integer> save(Regulators regulators) {
        GeneralResult<Integer> result = new GeneralResult<Integer>();
        try {
            int id = dao.save(regulators);
            result.setData(id);
        } catch (Exception e) {
            result.setResultCode(ResultEnum.E_DATABASE_INSERT);
        }
        return result;
    }

    public GeneralResult<List<Regulators>> getAll() {
        String hql = "from Regulators";
        List<Regulators> regulatorsList = dao.findList(hql);
        GeneralResult<List<Regulators>> result = new GeneralResult<List<Regulators>>();
        if (null == regulatorsList || regulatorsList.isEmpty()) {
            result.setResultCode(ResultEnum.E_NOT_EXIST);
        } else {
            result.setData(regulatorsList);
        }
        return result;
    }

    public GeneralResult<Regulators> getById(int id) {
        Regulators regulators = dao.getById(id);
        GeneralResult<Regulators> result = new GeneralResult<Regulators>();
        if (null != regulators) {
            result.setData(regulators);
        } else {
            result.setResultCode(ResultEnum.E_NOT_EXIST);
        }
        return result;
    }

    public GeneralResult update(Regulators obj) {
        try {
            dao.update(obj);
        } catch (Exception e) {
            return new GeneralResult(ResultEnum.E_DATABASE_UPDATE);
        }
        return new GeneralResult();
    }

    public void delete(int id) {
        try {
            dao.delete(new Regulators(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public GeneralResult delAll(int[] ids) {
        try {
            for (int id : ids) {
                dao.delete(new Regulators(id));
            }
        } catch (Exception e) {
            return new GeneralResult(ResultEnum.E_DATABASE_DELETE);
        }
        return new GeneralResult();
    }

    //gages of contract
    public void save(RegulatorsCompany regulatorsCompany) {
        try {
            regulatorsCompanyDao.save(regulatorsCompany);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(RegulatorsCompany regulatorsCompany) {
        try {
            regulatorsCompanyDao.update(regulatorsCompany);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //regulate account
    public void save(RegulateAccount regulateAccount) {
        try {
            regulateAccountDao.save(regulateAccount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(RegulateAccount regulateAccount) {
        try {
            regulateAccountDao.update(regulateAccount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
