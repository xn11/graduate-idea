package com.cebbank.gage.dao.impl;

import com.cebbank.gage.dao.NoticeDao;
import com.cebbank.gage.model.Notice;
import org.springframework.stereotype.Repository;

/**
 * Created by xn on 2017/3/6.
 */
@Repository
public class NoticeDaoImpl extends HibernateBaseDaoImpl<Notice> implements NoticeDao {

    public NoticeDaoImpl() {
        super(Notice.class);
    }
}
