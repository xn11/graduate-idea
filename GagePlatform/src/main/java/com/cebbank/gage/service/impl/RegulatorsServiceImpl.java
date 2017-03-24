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
        dao.save(regulators);
    }

    public List<Regulators> getAll() {
        return dao.getAll();
    }

    public Regulators getById(int id) {
        return dao.getById(id);
    }

    public void update(Regulators obj) {
        dao.update(obj);
    }

    public void delete(int id) {
        dao.delete(new Regulators(id));
    }

    //gages of contract
    public void save(RegulatorsCompany regulatorsCompany) {
        regulatorsCompanyDao.save(regulatorsCompany);
    }

    public void update(RegulatorsCompany regulatorsCompany) {
        regulatorsCompanyDao.update(regulatorsCompany);
    }

    //regulate account
    public void save(RegulateAccount regulateAccount) {
        regulateAccountDao.save(regulateAccount);
    }

    public void update(RegulateAccount regulateAccount) {
        regulateAccountDao.update(regulateAccount);
    }


}
