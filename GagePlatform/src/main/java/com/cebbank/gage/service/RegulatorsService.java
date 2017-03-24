package com.cebbank.gage.service;


import com.cebbank.gage.model.*;

import java.util.List;

/**
 * Created by xn on 2017/3/6.
 */
public interface RegulatorsService {
    public void save(Regulators regulators);

    public List<Regulators> getAll();

    public Regulators getById(int id);

    public void update(Regulators contract);

    public void delete(int id);

    //regulator = regulators_company
    public void save(RegulatorsCompany regulatorsCompany);

    public void update(RegulatorsCompany contractGage);

    //regulate account
    public void save(RegulateAccount regulateAccount);

    public void update(RegulateAccount regulateAccount);

}
