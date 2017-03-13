package com.cebbank.gage.service.impl;

import com.cebbank.gage.DAO.UserDao;
import com.cebbank.gage.model.User;
import com.cebbank.gage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xn on 2017/3/6.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public void saveUsers(List<User> us) {
        for (User u: us) {
            userDao.save(u);
        }
    }

//    public List<User> getAllUsernames() {
//        return null;
//    }

    /*public void saveUsers(List<User> us) {
        for (User u : us) {
            userDao.save(u);
        }
    }

    public List<User> getAllUsernames() {
//        return userDao.findAll();
        return null;
    }*/
}
