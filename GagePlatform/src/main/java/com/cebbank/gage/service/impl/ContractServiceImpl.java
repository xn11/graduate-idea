package com.cebbank.gage.service.impl;

import com.cebbank.gage.dao.ContractDao;
import com.cebbank.gage.dao.ContractGageDao;
import com.cebbank.gage.model.Contract;
import com.cebbank.gage.model.ContractGage;
import com.cebbank.gage.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xn on 2017/3/6.
 */
@Service("contractService")
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractDao dao;
    @Autowired
    private ContractGageDao contractGageDao;


    public void save(Contract contract) {
        try {
            dao.save(contract);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Contract> getAll() {
        return dao.getAll();
    }

    public Contract getById(int id) {
        return dao.getById(id);
    }

    public void update(Contract obj) {
        try {
            dao.update(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            dao.delete(new Contract(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //gages of contract
    public void save(ContractGage contractGage) {
        try {
            contractGageDao.save(contractGage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(ContractGage contractGage) {
        try {
            contractGageDao.update(contractGage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
