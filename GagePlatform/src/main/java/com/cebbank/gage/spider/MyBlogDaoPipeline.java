package com.cebbank.gage.spider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

import javax.annotation.Resource;

/**
 * Created by xn on 2017/4/9.
 */
/*
@Service("myBlogDaoPipeline")
public class MyBlogDaoPipeline implements PageModelPipeline<MyBlog> {

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
}*/
