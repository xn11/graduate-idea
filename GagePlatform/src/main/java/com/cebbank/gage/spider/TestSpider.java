package com.cebbank.gage.spider;

import org.apache.log4j.BasicConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.model.ConsolePageModelPipeline;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

/**
 * Created by xn on 2017/4/9.
 */
/*@Component
public class TestSpider {

    @Qualifier("MyBlogDaoPipeline")
    @Autowired
    private PageModelPipeline myBlogDaoPipeline;

    public void spider(){
//        BasicConfigurator.configure();
        *//*OOSpider.create(
                Site.me(),
                new ConsolePipeline(),
                MyBlog.class)
                .addUrl("http://blog.csdn.net/xn_28/article/details").run();*//*
        Spider spider = OOSpider.create(
                Site.me(),
                myBlogDaoPipeline,
                MyBlog.class)
                .addUrl("http://blog.csdn.net/xn_28/article/details");

        spider.addPipeline(new ConsolePipeline()).run();
    }

}*/
