package com.cebbank.gage.dao.impl;

import com.cebbank.gage.dao.HibernateBaseDao;
import com.cebbank.gage.util.Parameter;
import org.hibernate.*;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Created by xn on 2017/3/12.
 */
public class HibernateBaseDaoImpl<T> extends HibernateDaoSupport implements HibernateBaseDao<T> {
    private Class<T> entityClass;

    //construct methods
    public HibernateBaseDaoImpl() {
    }

    public HibernateBaseDaoImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Resource(name = "sessionFactory")
    public final void setSessionFactoryOverride(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    private Session getSession() {
        return getSessionFactory().getCurrentSession();
    }

    /**
     * @param query
     * @param parameter set sql parameters
     */
    private void setParameter(Query query, Parameter parameter) {
        if (parameter != null) {
            Set<String> keySet = parameter.keySet();
            for (String string : keySet) {
                Object value = parameter.get(string);
                if (value instanceof Collection<?>) {
                    query.setParameterList(string, (Collection<?>) value);
                } else if (value instanceof Object[]) {
                    query.setParameterList(string, (Object[]) value);
                } else {
                    query.setParameter(string, value);
                }
            }
        }
    }

    public int save(T entity) throws Exception{
        int res = (Integer) getSession().save(entity);
        getSession().flush();
        return res;
    }

    public void update(T entity) throws Exception {
        getSession().update(entity);
        getSession().flush();
    }

    public void saveOrUpdate(T entity) throws Exception {
        getSession().saveOrUpdate(entity);
        getSession().flush();
    }

    public void delete(T entity) throws Exception {
        getSession().delete(entity);
        getSession().flush();
    }

    /**
     * 按主键删除，必须保证有T(int id)构造函数
     * @param id
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public void delete(int id) throws Exception {
        T entity = entityClass.getConstructor(int.class).newInstance(id);
        getSession().delete(entity);
        getSession().flush();
    }

    public void deleteWithHql(String hql) throws Exception {
        Query query = getSession().createQuery(hql);
        query.executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public T getById(int id) {
        return (T) getSession().get(entityClass, id);
    }

    @SuppressWarnings("unchecked")
    public List<T> getAll() {
        Criteria criteria = getSession().createCriteria(entityClass);
        return criteria.list();
    }

    public T findOne(String hql) {
        return findOne(hql, null);
    }

    @SuppressWarnings("unchecked")
    public T findOne(String hql, Parameter parameter) {
        Query query = getSession().createQuery(hql);
        setParameter(query, parameter);
        return (T) query.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public List<T> findList(String hql) {
        return findList(hql, null);
    }

    @SuppressWarnings("unchecked")
    public List<T> findList(String hql, Parameter parameter) {
        Query query = getSession().createQuery(hql);
        setParameter(query, parameter);
        return (List<T>) query.list();
    }
}
