package com.cebbank.gage.model;

import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.TargetUrl;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by xn on 2017/4/8.
 */
@Entity
@Table(name = "mysteel")
//@TargetUrl("https://github.com/\\w+/\\w+")
@TargetUrl("http://www.100ppi.com/sf")
@ExtractBy(value = "//table[@class='ftab']/tbody/tr[@bgcolor='#fafdff']", multi = true)
public class Mysteel {
    @Id
    @GeneratedValue
    private int id;

    //    @ExtractBy(value = "//body/div[@class='title']/text()", notNull = true)
    @ExtractBy(value = "//a/text()", notNull = true)
    private String name;

//    @ExtractByUrl("http://index.mysteel.com/xpic/detail.ms?tabName=(\\w+)")
    private String unit = "元/吨";

    //    @ExtractBy(value = "//table/tbody/tr[2]/td[1]/text()", notNull = true)
    @ExtractBy(value = "//div[@class='title2']/text()", source = ExtractBy.Source.RawHtml)
    private String time;

    @Transient
    //    @ExtractBy(value = "//table/tbody/tr[2]/td[2]/text()", notNull = true)
//    @ExtractBy(value = "//table[@class='ftab']/tbody/tr[@bgcolor='#fafdff']/td[2]/text()", source = ExtractBy.Source.RawHtml, notNull = true)
    @ExtractBy(value = "//body/text()")
    private String priceText;

    private double price;

    //    @ExtractByUrl("https://github\\.com/(\\w+)/.*")
//    @ExtractByUrl
    @ExtractBy(value = "//a/@href")
    private String url;

    @Column(columnDefinition = "timestamp default CURRENT_TIMESTAMP")
    private Date timestamp;


    public Mysteel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPriceText() {
        return priceText;
    }

    public void setPriceText(String priceText) {
        this.priceText = priceText;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Mysteel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", time='" + time + '\'' +
                ", priceText='" + priceText + '\'' +
                ", price=" + price +
                ", url='" + url + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
