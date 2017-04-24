package com.cebbank.gage.service;


import com.cebbank.gage.common.GeneralResult;
import com.cebbank.gage.model.Contract;
import com.cebbank.gage.model.ContractGage;

import java.util.List;

/**
 * Created by xn on 2017/3/6.
 */
public interface ContractService {
    public GeneralResult save(Contract contract);

    public List<Contract> getAll();

    public GeneralResult<Contract> getById(int id);

    public GeneralResult update(Contract contract);

    public GeneralResult saveOrUpdate(Contract contract);

    public GeneralResult delete(int id);

    //gages of contract
    public GeneralResult save(ContractGage contractGage);

    public GeneralResult update(ContractGage contractGage);

}
