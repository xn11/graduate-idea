package com.cebbank.gage.dao;

import com.cebbank.gage.util.Page;
import com.cebbank.gage.util.Parameter;

import java.util.Collection;
import java.util.List;

/**
 * Created by xn on 2017/3/9.
 */
public interface HibernateBaseDao<T> {

    //增
    public int save(T entity);
//    public void saveAll(final List<T> list);

    //改
    public void update(T entity);
    public void saveOrUpdate(T entity);

    //删
    public void delete(T entity);
    public void deleteWithHql(String hql);
//    public void deleteAll(final Collection entities);

    //查
    public T getById(int id);
    public List<T> getAll();
    //createQuery（Query）
    public T findOne(String hql);
    public T findOne(String hql, Parameter parameter);
    //list查询
    public List<T> findList(String hql);
    public List<T> findList(String hql, Parameter parameter);

    //分页查询
//    public Page<T> findPage(final int currentPage, final int pageSize, final String queryHql, final String countHql, final Object[] values)
//            throws HibernateException,SQLException;
//    public Page<T> findPage(final int currentPage, final int pageSize, final String queryHql, final String countHql)
//            throws HibernateException,SQLException;

    //查询满足条件的记录数
//    public long findCount(final String hql);
//    public long findCount(final String hql, final Object[] values);
}
