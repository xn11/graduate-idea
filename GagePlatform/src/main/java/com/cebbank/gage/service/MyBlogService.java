package com.cebbank.gage.service;

import com.cebbank.gage.model.Gage;
import com.cebbank.gage.model.MyBlog;
import com.cebbank.gage.model.Price;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

import java.util.List;

/**
 * Created by xn on 2017/3/6.
 */
public interface MyBlogService extends PageModelPipeline<MyBlog> {

    public void save(MyBlog myBlog);

}
