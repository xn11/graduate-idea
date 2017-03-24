package com.cebbank.gage.service;


import com.cebbank.gage.model.Contract;
import com.cebbank.gage.model.ContractGage;

import java.util.List;

/**
 * Created by xn on 2017/3/6.
 */
public interface ContractService {
    public void save(Contract contract);

    public List<Contract> getAll();

    public Contract getById(int id);

    public void update(Contract contract);

    public void delete(int id);

    //gages of contract
    public void save(ContractGage contractGage);

    public void update(ContractGage contractGage);

}
