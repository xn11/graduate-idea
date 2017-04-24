package com.cebbank.gage.service;

import com.cebbank.gage.common.GeneralResult;
import com.cebbank.gage.common.NoticeStatusTypeEnum;
import com.cebbank.gage.model.Notice;

import java.util.List;

/**
 * Created by xn on 2017/3/6.
 */
public interface NoticeService {
    public void saveList(List<Notice> list);

    public GeneralResult<Integer> save(Notice notice);

    public GeneralResult<List<Notice>> getNoticeList(String uid, NoticeStatusTypeEnum status);

    public List<Notice> getAll();

    public GeneralResult<Notice> getById(int id);

    public GeneralResult update(Notice notice);

    public void delete(int id);

//    public List<NoticeGage> getGageList(int id);

}
