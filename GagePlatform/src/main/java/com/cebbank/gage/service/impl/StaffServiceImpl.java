package com.cebbank.gage.service.impl;

import com.cebbank.gage.common.GeneralResult;
import com.cebbank.gage.common.ResultEnum;
import com.cebbank.gage.dao.StaffDao;
import com.cebbank.gage.model.Staff;
import com.cebbank.gage.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xn on 2017/3/6.
 */
@Service("staffService")
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffDao dao;


    public void saveList(List<Staff> list) {
        try {
            for (Staff obj : list) {
                dao.save(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public GeneralResult<List<Staff>> getAll() {
        String hql = "from Staff";
        List<Staff> staffList = dao.findList(hql);
        GeneralResult<List<Staff>> result = new GeneralResult<List<Staff>>();
        if (null == staffList || staffList.isEmpty()) {
            result.setResultCode(ResultEnum.E_NOT_EXIST);
        } else {
            result.setData(staffList);
        }
        return result;
    }

    public GeneralResult<Staff> getById(int id) {
        Staff staff = dao.getById(id);
        GeneralResult<Staff> result = new GeneralResult<Staff>();
        if (null != staff) {
            result.setData(staff);
        } else {
            result.setResultCode(ResultEnum.E_NOT_EXIST);
        }
        return result;
    }

    public void update(Staff obj) {
        try {
            dao.update(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            dao.delete(new Staff(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
