package com.cebbank.gage.dao.impl;

import com.cebbank.gage.dao.UserDao;
import com.cebbank.gage.model.User;
import org.springframework.stereotype.Repository;

/**
 * Created by xn on 2017/3/6.
 */
@Repository
public class UserDaoImpl extends HibernateBaseDaoImpl<User> implements UserDao {

    public UserDaoImpl() {
        super(User.class);
    }

//    public List<User> getAll() {
//        Criteria criteria = getSession().createCriteria(User.class);
//        return  criteria.list();
//    }
//
//    public User getById(int id) {
//        return (User)getSession().get(User.class, id);
//    }
//
//    public User getOne(String hql, Parameter parameter) {
//        Query query = getSession().createQuery(hql);
//        setParameter(query, parameter);
//        return (User)query.setMaxResults(1).uniqueResult();
//    }
//
//    public int save(User user) {
//        return (Integer)getSession().save(user);
//    }
//
//    public void update(User user) {
//        getSession().update(user);
//    }
//
//    public void delete(int id) {
//        getSession().delete(new User(id));
//    }
/*
    @Autowired
    private SessionFactory sessionFactory;

    public int save(User u) {
        return (Integer) sessionFactory.getCurrentSession().save(u);
    }

    public List<User> findAll() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        return criteria.list();
    }
    */


}
