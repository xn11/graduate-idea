package com.cebbank.gage.service.impl;

import com.cebbank.gage.common.GeneralResult;
import com.cebbank.gage.common.ResultEnum;
import com.cebbank.gage.dao.NoticeDao;
import com.cebbank.gage.model.Notice;
import com.cebbank.gage.service.NoticeService;
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

    public List<Notice> getAll() {
        return noticeDao.getAll();
    }

    public Notice getById(int id) {
        return noticeDao.getById(id);
    }

    public void update(Notice obj) {
        try {
            noticeDao.update(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            noticeDao.delete(new Notice(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
