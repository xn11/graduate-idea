package com.cebbank.gage.DAO;

import com.cebbank.gage.model.User;

import java.util.List;

/**
 * Created by mark on 4/24/15.
 */
public interface UserDAO {
    public int save(User u);
    public List<User> findAll();
}
