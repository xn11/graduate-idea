package com.cebbank.gage.DAO;

import com.cebbank.gage.model.User;

import java.util.List;

/**
 * Created by xn on 2017/3/6.
 */
public interface UserDao{
    /*
    public int save(User u);
    public List<User> findAll();
    */

    public List<User> getAll();

    public int save(User user);

    public void update(User user);

    public void delete(int id);
}
