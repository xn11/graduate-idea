package com.cebbank.gage.dao.impl;

import com.cebbank.gage.dao.RegulateAccountDao;
import com.cebbank.gage.model.RegulateAccount;
import org.springframework.stereotype.Repository;

/**
 * Created by xn on 2017/3/6.
 */
@Repository
public class RegulateAccountDaoImpl extends HibernateBaseDaoImpl<RegulateAccount> implements RegulateAccountDao {

    public RegulateAccountDaoImpl() {
        super(RegulateAccount.class);
    }
}
