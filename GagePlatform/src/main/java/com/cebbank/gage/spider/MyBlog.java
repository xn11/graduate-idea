package com.cebbank.gage.spider;

import org.apache.log4j.BasicConfigurator;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.ConsolePageModelPipeline;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.TargetUrl;
import us.codecraft.webmagic.pipeline.ConsolePipeline;

import java.util.Date;

/**
 * Created by xn on 2017/4/8.
 */
//@Entity
//@Table(name = "blog")
@TargetUrl("http://blog.csdn.net/xn_28/article/details/\\d+")
public class MyBlog {
//    @Id
//    @GeneratedValue
//    private int id;

    @ExtractBy(value = "//h1/span[@class='link_title']/a/text()", notNull = true)
    private String title;

    @ExtractBy(value = "//div[@class='article_r']/span[@class='link_postdate']/text()")
    private String date;

    //    @Column(columnDefinition = "timestamp default CURRENT_TIMESTAMP")
    private Date timestamp;

//    @ExtractBy(value = "//div[@class='BlogTags']/a/text()", multi = true)
//    private List<String> tags;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "MyBlog{" +
                "title='" + title + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public static void main(String[] args) {
        BasicConfigurator.configure();
        OOSpider.create(
                Site.me(),
                new ConsolePageModelPipeline(),
                MyBlog.class)
                .addUrl("http://blog.csdn.net/xn_28/article/details").thread(5).run();
    }
}
