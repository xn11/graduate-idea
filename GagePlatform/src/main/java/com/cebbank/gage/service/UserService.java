package com.cebbank.gage.service;

import com.cebbank.gage.model.User;

import java.util.List;

/**
 * Created by mark on 4/24/15.
 */
public interface UserService {
    public void saveUsers(List<User> us);
    public List<User> getAllUsernames();
}
