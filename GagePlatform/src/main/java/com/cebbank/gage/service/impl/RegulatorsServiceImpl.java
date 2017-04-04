package com.cebbank.gage.service.impl;

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


    public void save(Regulators regulators) {
        try {
            dao.save(regulators);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Regulators> getAll() {
        return dao.getAll();
    }

    public Regulators getById(int id) {
        return dao.getById(id);
    }

    public void update(Regulators obj) {
        try {
            dao.update(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            dao.delete(new Regulators(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
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
