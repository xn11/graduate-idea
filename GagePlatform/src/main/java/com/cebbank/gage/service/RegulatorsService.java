package com.cebbank.gage.service;


import com.cebbank.gage.common.GeneralResult;
import com.cebbank.gage.model.*;

import java.util.List;

/**
 * Created by xn on 2017/3/6.
 */
public interface RegulatorsService {
    /*
     * regulators
     */
    public GeneralResult<Integer> save(Regulators regulators);

    //regulators list
    public GeneralResult<List<Regulators>> getAll();

    public GeneralResult<Regulators> getById(int id);

    public GeneralResult update(Regulators contract);

    public void delete(int id);

    public GeneralResult delAll(int[] ids);

    /*
     * regulator = regulators_company
     */
    /*public void save(RegulatorsCompany regulatorsCompany);

    public void update(RegulatorsCompany contractGage);*/

    /*
     * regulate account
     */
    public void save(RegulateAccount regulateAccount);

    public void update(RegulateAccount regulateAccount);
}
