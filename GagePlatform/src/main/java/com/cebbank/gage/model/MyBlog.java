package com.cebbank.gage.model;

import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.TargetUrl;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by xn on 2017/4/8.
 */
@Entity
@Table(name = "blog")
@TargetUrl("http://blog.csdn.net/xn_28/article/details/\\d+")
public class MyBlog {
    @Id
    @GeneratedValue
    private int id;

    @ExtractBy(value = "//h1/span[@class='link_title']/a/text()", notNull = true)
    private String title;

    @ExtractBy(value = "//div[@class='article_r']/span[@class='link_postdate']/text()")
    private String date;

    @Column(columnDefinition = "timestamp default CURRENT_TIMESTAMP")
    private Date timestamp;

//    @ExtractBy(value = "//div[@class='BlogTags']/a/text()", multi = true)
//    private List<String> tags;


    public MyBlog() {
    }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
}
