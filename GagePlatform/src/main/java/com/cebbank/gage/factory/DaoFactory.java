package com.cebbank.gage.factory;

import com.cebbank.gage.dao.*;
import com.cebbank.gage.dao.impl.*;

/**
 * Created by xn on 2017/3/11.
 */
public enum DaoFactory {
    INSTANCE;

    private UserDao userDao;

    public UserDao getUserDao() {
        if(null == userDao) {
            userDao = new UserDaoImpl();
        }
        return userDao;
    }


}

