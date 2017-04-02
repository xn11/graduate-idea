package com.cebbank.gage.service;

import com.cebbank.gage.common.GeneralResult;
import com.cebbank.gage.common.RoleEnum;
import com.cebbank.gage.model.User;

import java.util.List;

/**
 * Created by xn on 2017/3/6.
 */
public interface UserService {
    public void saveUsers(List<User> us);

    public List<User> getAllUsernames();

    public User getById(int id);

    public void update(User user);

    public void delete(int id);

    public void delAll(int[] ids);

    //login
    public GeneralResult<User> getByIdAndPassword(String id, String password);

    //userlist
    public GeneralResult<List<User>> getAll();
    public GeneralResult<List<User>> getAll(RoleEnum role);
}
