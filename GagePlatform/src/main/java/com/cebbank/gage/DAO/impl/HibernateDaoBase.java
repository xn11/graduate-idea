package com.cebbank.gage.DAO.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

/**
 * Created by xn on 2017/3/12.
 */
public class HibernateDaoBase extends HibernateDaoSupport {
    @Resource(name = "sessionFactory")
    public final void setSessionFactoryOverride(SessionFactory sessionFactory){
        super.setSessionFactory(sessionFactory);
    }

    public Session getSession(){
        return getSessionFactory().getCurrentSession();
    }

}
