package com.cebbank.gage.service.impl;

import com.cebbank.gage.dao.BiddingDao;
import com.cebbank.gage.model.Bidding;
import com.cebbank.gage.service.BiddingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xn on 2017/3/6.
 */
@Service("biddingService")
public class BiddingServiceImpl implements BiddingService {

    @Autowired
    private BiddingDao biddingDao;

    public List<Bidding> getAll() {
        return biddingDao.getAll();
    }

    public Bidding getById(int id) {
        return biddingDao.getById(id);
    }

    public void update(Bidding obj) {
        try {
            biddingDao.update(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            biddingDao.delete(new Bidding(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
