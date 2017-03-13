//package com.cebbank.gage.DAO;
//
//import com.cebbank.gage.util.Page;
//import com.cebbank.gage.util.Parameter;
//import org.hibernate.HibernateException;
//
//import java.sql.SQLException;
//import java.util.*;
//
///**
// * Created by xn on 2017/3/9.
// */
//public interface BaseDao<T> {
//    //单个CRUD
//    public void save(final T entity) throws Exception;
//    public void delete(final T entity) throws Exception;
//    public void deleteWithHql(final String hql) throws Exception;
//    public void update(final T entity) throws Exception;
//    public T getById(final int id) throws Exception;
//
//    //批处理
//    public int saveAll(final List<T> list) throws Exception;
//    public void deleteAll(final Collection entities) throws Exception;
//
//    //createQuery（Query）
//    public T findOne(final String hql) throws Exception;
//    public T findOne(final String hql, final Parameter parameter) throws Exception;
//
//    //list查询
//    public List<T> findList(final String hql) throws Exception;
//    public List<T> findList(final String hql, final Parameter parameter) throws Exception;
//
//    //分页查询
//    public Page<T> findPage(final int currentPage, final int pageSize, final String queryHql, final String countHql, final Object[] values)
//            throws HibernateException,SQLException;
//    public Page<T> findPage(final int currentPage, final int pageSize, final String queryHql, final String countHql)
//            throws HibernateException,SQLException;
//
//    //查询满足条件的记录数
//    public long findCount(final String hql);
//    public long findCount(final String hql, final Object[] values);
//}
