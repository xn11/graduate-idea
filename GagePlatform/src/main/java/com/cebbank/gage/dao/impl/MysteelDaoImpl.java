package com.cebbank.gage.dao.impl;

import com.cebbank.gage.dao.MyBlogDao;
import com.cebbank.gage.dao.MysteelDao;
import com.cebbank.gage.model.MyBlog;
import com.cebbank.gage.model.Mysteel;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 * Created by xn on 2017/3/6.
 */
@Repository
public class MysteelDaoImpl extends HibernateBaseDaoImpl<Mysteel> implements MysteelDao {

    public MysteelDaoImpl() {
        super(Mysteel.class);
    }

    @Override
    public int save(Mysteel entity) throws Exception{
        int res = (Integer) getSession().save(entity);
        getSession().flush();
        getSession().close();
        return res;
    }

    private Session getSession() {
        return getSessionFactory().openSession();
    }
}
