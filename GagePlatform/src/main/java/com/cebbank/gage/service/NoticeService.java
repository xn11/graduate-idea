package com.cebbank.gage.service;

import com.cebbank.gage.model.Notice;

import java.util.List;

/**
 * Created by xn on 2017/3/6.
 */
public interface NoticeService {
    public void saveList(List<Notice> list);

    public List<Notice> getAll();

    public Notice getById(int id);

    public void update(Notice notice);

    public void delete(int id);

//    public List<NoticeGage> getGageList(int id);

}
