package com.cebbank.gage.dao.impl;

import com.cebbank.gage.dao.NoticeGageDao;
import com.cebbank.gage.model.NoticeGage;
import org.springframework.stereotype.Repository;

/**
 * Created by xn on 2017/3/6.
 */
@Repository
public class NoticeGageDaoImpl extends HibernateBaseDaoImpl<NoticeGage> implements NoticeGageDao {

    public NoticeGageDaoImpl() {
        super(NoticeGage.class);
    }
}
