package com.cebbank.gage.service.impl;

import com.cebbank.gage.common.GeneralResult;
import com.cebbank.gage.common.ResultEnum;
import com.cebbank.gage.common.RoleEnum;
import com.cebbank.gage.dao.UserDao;
import com.cebbank.gage.model.User;
import com.cebbank.gage.service.UserService;
import com.cebbank.gage.util.GageUtils;
import com.cebbank.gage.util.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xn on 2017/3/6.
 */
@Service("userService")
//@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /*public void saveUsers(List<User> us) {
        for (User u : us) {
            userDao.save(u);
        }
    }*/

    /*public List<User> getAllUsernames() {
        return userDao.getAll();
    }*/

    public GeneralResult<User> getById(int id) {
        User user = userDao.getById(id);
        GeneralResult<User> result = new GeneralResult<User>();
        if (null != user) {
            result.setData(user);
        } else {
            result.setResultCode(ResultEnum.E_NOT_EXIST);
        }
        return result;
    }

    public GeneralResult<User> getByUid(String uid) {
        String hql = "from User where name=:uid";
        User user = userDao.findOne(hql, new Parameter(new Object[][]{{"uid", uid}}));

        GeneralResult<User> result = new GeneralResult<User>();
        if (null != user) {
            result.setData(user);
        } else {
            result.setResultCode(ResultEnum.E_NOT_EXIST);
        }
        return result;
    }

    public GeneralResult update(User user) {
        try {
            userDao.update(user);
        } catch (Exception e) {
            return new GeneralResult(ResultEnum.E_DATABASE_UPDATE);
        }
        return new GeneralResult();
    }

    public GeneralResult delete(int id) {
        try {
            userDao.delete(new User(id));
        } catch (Exception e) {
            return new GeneralResult(ResultEnum.E_DATABASE_DELETE);
        }
        return new GeneralResult();
    }

    public GeneralResult delAll(int[] ids) {
        try {
            for (int id : ids) {
                userDao.delete(new User(id));
            }
        } catch (Exception e) {
            return new GeneralResult(ResultEnum.E_DATABASE_DELETE);
        }
        return new GeneralResult();
    }

    public GeneralResult<User> getByIdAndPassword(String id, String password) {
        String hql = "from User where name=:uid";
        if (GageUtils.isNumeric(id)) {
            hql = "from User where id=:uid";
        }
        User user = userDao.findOne(hql, new Parameter(new Object[][]{{"uid", id}}));
        GeneralResult<User> result = new GeneralResult<User>();
        if (null == user) {
            result.setResultCode(ResultEnum.E_NOT_EXIST);
        } else if (user.getStatus() < 0) {
            result.setResultCode(ResultEnum.E_INVALID_DATA);
        } else if (!user.getPassword().equals(password)) {
            result.setResultCode(ResultEnum.E_PASSWORD_WRONG);
        } else {
            result.setData(user);
        }
        return result;
    }

    public GeneralResult<List<User>> getAll() {
//        String hql = "from User where status>=0";
        String hql = "from User";
        List<User> userList = userDao.findList(hql);
        GeneralResult<List<User>> result = new GeneralResult<List<User>>();
        if (null == userList || userList.isEmpty()) {
            result.setResultCode(ResultEnum.E_NOT_EXIST);
        } else {
            result.setData(userList);
        }
        return result;
    }

    public GeneralResult<List<User>> getAll(RoleEnum role) {
//        String hql = "from User where status>=0 and role_id=" + role.getId();
        String hql = "from User where role_id=" + role.getId();
        List<User> userList = userDao.findList(hql);
        GeneralResult<List<User>> result = new GeneralResult<List<User>>();
        if (null == userList || userList.isEmpty()) {
            result.setResultCode(ResultEnum.E_NOT_EXIST);
        } else {
            result.setData(userList);
        }
        return result;
    }

    public GeneralResult<List<User>> getValidAll() {
        String hql = "from User where status>=0";
        List<User> userList = userDao.findList(hql);
        GeneralResult<List<User>> result = new GeneralResult<List<User>>();
        if (null == userList || userList.isEmpty()) {
            result.setResultCode(ResultEnum.E_NOT_EXIST);
        } else {
            result.setData(userList);
        }
        return result;
    }

    public GeneralResult<Integer> save(User user) {
        GeneralResult<Integer> result = new GeneralResult<Integer>();
        try {
            int id = userDao.save(user);
            result.setData(id);
        } catch (Exception e) {
            result.setResultCode(ResultEnum.E_DATABASE_INSERT);
        }
        return result;
    }

}
