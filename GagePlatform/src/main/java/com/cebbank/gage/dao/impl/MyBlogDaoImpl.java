package com.cebbank.gage.dao.impl;

import com.cebbank.gage.dao.MyBlogDao;
import com.cebbank.gage.model.MyBlog;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 * Created by xn on 2017/3/6.
 */
@Repository
public class MyBlogDaoImpl extends HibernateBaseDaoImpl<MyBlog> implements MyBlogDao {

    public MyBlogDaoImpl() {
        super(MyBlog.class);
    }

    @Override
    public int save(MyBlog entity) throws Exception{
        int res = (Integer) getSession().save(entity);
        getSession().flush();
        getSession().close();
        return res;
    }

    private Session getSession() {
        return getSessionFactory().openSession();
    }
}
