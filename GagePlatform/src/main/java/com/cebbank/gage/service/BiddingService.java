package com.cebbank.gage.service;

import com.cebbank.gage.model.Bidding;

import java.util.List;

/**
 * Created by xn on 2017/3/6.
 */
public interface BiddingService {
//    public void saveList(List<Gage> list);

    public List<Bidding> getAll();

    public Bidding getById(int id);

    public void update(Bidding obj);

    public void delete(int id);

//    public List<NoticeGage> getGageList(int id);

}
