package com.cebbank.gage.service.impl;

import com.cebbank.gage.dao.MyBlogDao;
import com.cebbank.gage.dao.MysteelDao;
import com.cebbank.gage.model.MyBlog;
import com.cebbank.gage.model.Mysteel;
import com.cebbank.gage.service.MyBlogService;
import com.cebbank.gage.service.MysteelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Task;

/**
 * Created by xn on 2017/3/6.
 */
@Service("mysteelService")
public class MysteelServiceImpl implements MysteelService {

    @Autowired
    private MysteelDao dao;

    public void process(Mysteel obj, Task task) {
        //调用MyBatis DAO保存结果
        try {
            String priceText = obj.getPriceText().trim().split(" ")[0];
//            priceText = priceText.substring(0, priceText.indexOf('.') + 3);
            obj.setPrice(Double.parseDouble(priceText));

            String time = obj.getTime();
            int m = time.indexOf('m') + 1;
            obj.setTime(time.substring(m, m + 18).trim());

//            System.out.println(obj);
            dao.save(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
