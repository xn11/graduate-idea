package com.cebbank.gage.service;

import com.cebbank.gage.common.GeneralResult;
import com.cebbank.gage.common.RoleEnum;
import com.cebbank.gage.model.User;

import java.util.List;

/**
 * Created by xn on 2017/3/6.
 */
public interface UserService {

    public GeneralResult<Integer> save(User user);

    public GeneralResult<User> getById(int id);

    public GeneralResult update(User user);

    public GeneralResult delete(int id);

    public GeneralResult delAll(int[] ids);

    //login
    public GeneralResult<User> getByIdAndPassword(String id, String password);

    //userlist
    public GeneralResult<List<User>> getAll();

    public GeneralResult<List<User>> getAll(RoleEnum role);

    public GeneralResult<List<User>> getValidAll();
}
