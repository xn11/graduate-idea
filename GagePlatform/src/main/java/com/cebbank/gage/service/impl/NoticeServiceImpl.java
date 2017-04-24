package com.cebbank.gage.service.impl;

import com.cebbank.gage.common.GeneralResult;
import com.cebbank.gage.common.NoticeStatusTypeEnum;
import com.cebbank.gage.common.NoticeTypeEnum;
import com.cebbank.gage.common.ResultEnum;
import com.cebbank.gage.dao.NoticeDao;
import com.cebbank.gage.model.Notice;
import com.cebbank.gage.service.NoticeService;
import com.cebbank.gage.util.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xn on 2017/3/6.
 */
@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeDao noticeDao;

    public void saveList(List<Notice> list) {
        try {
            for (Notice obj : list) {
                noticeDao.save(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public GeneralResult<Integer> save(Notice notice) {
        GeneralResult<Integer> result = new GeneralResult<Integer>();
        try {
            int id = noticeDao.save(notice);
            result.setData(id);
        } catch (Exception e) {
            result.setResultCode(ResultEnum.E_DATABASE_INSERT);
        }
        return result;
    }
    public GeneralResult<List<Notice>> getNoticeList(String uid, NoticeStatusTypeEnum status) {
        int id = Integer.parseInt(uid.substring(1));
        String hql = "select new Notice(notice.id,notice.type,notice.contract,notice.director,notice.status,notice.timestamp,notice.checkTime,notice.attachPath,notice.note) from Notice as notice join notice.contract as contract join contract.accountManager as staff with staff.id =:id  where notice.status =:status ";
//        String hql = "from Notice as notice inner join notice.contract as contract join contract.accountManager as staff with staff.id =:id  where notice.status =:status ";
        List<Notice> list = noticeDao.findList(hql, new Parameter(new Object[][]{{"id", id}, {"status", status}}));

        GeneralResult<List<Notice>> result = new GeneralResult<List<Notice>>();
        if (null == list) {
            result.setResultCode(ResultEnum.E_NOT_EXIST);
        } else {
            result.setData(list);
        }
        return result;
    }

    public List<Notice> getAll() {
        return noticeDao.getAll();
    }

    public GeneralResult<Notice> getById(int id) {
        Notice notice = noticeDao.getById(id);
        GeneralResult<Notice> result = new GeneralResult<Notice>();
        if (null == notice) {
            result.setResultCode(ResultEnum.E_NOT_EXIST);
        }else{
            result.setData(notice);
        }
        return result;
    }

    public GeneralResult update(Notice obj) {
        try {
            noticeDao.update(obj);
        } catch (Exception e) {
            return new GeneralResult(ResultEnum.E_DATABASE_UPDATE);
        }
        return new GeneralResult();
    }

    public void delete(int id) {
        try {
            noticeDao.delete(new Notice(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
