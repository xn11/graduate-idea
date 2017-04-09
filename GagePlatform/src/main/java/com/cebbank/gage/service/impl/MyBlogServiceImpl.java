package com.cebbank.gage.service.impl;

import com.cebbank.gage.dao.MyBlogDao;
import com.cebbank.gage.model.MyBlog;
import com.cebbank.gage.service.MyBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

/**
 * Created by xn on 2017/3/6.
 */
@Service("myBlogService")
public class MyBlogServiceImpl implements MyBlogService {

    @Autowired
    private MyBlogDao dao;

    public void process(MyBlog blog, Task task) {
        //调用MyBatis DAO保存结果
        try {
            dao.save(blog);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save(MyBlog myBlog) {
        try {
            dao.save(myBlog);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
