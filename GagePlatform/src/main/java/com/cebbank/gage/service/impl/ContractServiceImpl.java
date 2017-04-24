package com.cebbank.gage.service.impl;

import com.cebbank.gage.common.GeneralResult;
import com.cebbank.gage.common.ResultEnum;
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


    public GeneralResult save(Contract contract) {
        GeneralResult<Integer> result = new GeneralResult<Integer>();
        try {
            dao.save(contract);
        } catch (Exception e) {
            result.setResultCode(ResultEnum.E_DATABASE_INSERT);
        }
        return new GeneralResult();
    }

    public List<Contract> getAll() {
        return dao.getAll();
    }

    public GeneralResult<Contract> getById(int id) {
        Contract contract = dao.getById(id);
        GeneralResult<Contract> result = new GeneralResult<Contract>();
        if (null != contract) {
            result.setData(contract);
        } else {
            result.setResultCode(ResultEnum.E_NOT_EXIST);
        }
        return result;
    }

    public GeneralResult update(Contract obj) {
        try {
            dao.update(obj);
        } catch (Exception e) {
            return new GeneralResult(ResultEnum.E_DATABASE_UPDATE);
        }
        return new GeneralResult();
    }

    public GeneralResult saveOrUpdate(Contract contract) {
        try {
            dao.saveOrUpdate(contract);
        } catch (Exception e) {
            return new GeneralResult(ResultEnum.E_DATABASE_UPDATE);
        }
        return new GeneralResult();
    }

    public GeneralResult delete(int id) {
        try {
            dao.delete(new Contract(id));
        } catch (Exception e) {
            return new GeneralResult(ResultEnum.E_DATABASE_DELETE);
        }
        return new GeneralResult();

    }

    //gages of contract
    public GeneralResult save(ContractGage contractGage) {
        GeneralResult<Integer> result = new GeneralResult<Integer>();
        try {
            contractGageDao.save(contractGage);
        } catch (Exception e) {
            result.setResultCode(ResultEnum.E_DATABASE_INSERT);
        }
        return new GeneralResult();
    }

    public GeneralResult update(ContractGage contractGage) {
        try {
            contractGageDao.update(contractGage);
        } catch (Exception e) {
            return new GeneralResult(ResultEnum.E_DATABASE_UPDATE);
        }
        return new GeneralResult();
    }


}
