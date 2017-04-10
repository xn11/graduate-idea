package com.cebbank.gage.spider;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.ConsolePageModelPipeline;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.ExtractByUrl;
import us.codecraft.webmagic.model.annotation.TargetUrl;

import java.io.File;
import java.io.IOException;

/**
 * Created by xn on 2017/4/8.
 */
//@Entity
//@Table(name = "blog")
@TargetUrl("http://www.100ppi.com/sf")
//@TargetUrl("http://index.mysteel.com/xpic/*")
//@TargetUrl("http://index.mysteel.com/xpic/report.ms?*dateType=month")
@ExtractBy(value = "//table[@class='ftab']/tbody/tr[@bgcolor='#fafdff']",multi = true)
public class Test {
//    @Id
//    @GeneratedValue
//    private int id;

    @ExtractBy(value = "//a/text()")
//    @ExtractBy(value = "//div[@class='mLeftBt']/span[@class='btnson']/text()")
    private String title;

    //    @ExtractBy(value = "http://index.mysteel.com/xpic/report.ms.*//iframe[@id='indexNumberData']//table/tbody/tr[2]/td[1]/text()")
//    @ExtractBy(value = "//table[@class='ftab']/tbody/tr[@bgcolor='#fafdff']/td[2]/text()",source = ExtractBy.Source.RawHtml)
    @ExtractBy(value = "//body/text()")
    private String price;

//    @ExtractBy(value = "//div[@class='title2']/text()",source = ExtractBy.Source.RawHtml)
//    @ExtractByUrl
    @ExtractBy(value = "//a/@href")
    private String time;

    //    @Column(columnDefinition = "timestamp default CURRENT_TIMESTAMP")
//    private Date timestamp;

//    @ExtractBy(value = "//div[@class='BlogTags']/a/text()", multi = true)
//    private List<String> tags;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTime() {
        String res = time.split(" ")[1];
        return res;
    }

    public void setTime(String time) {
        this.time = time;
    }
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

//    public Date getTimestamp() {
//        return timestamp;
//    }
//
//    public void setTimestamp(Date timestamp) {
//        this.timestamp = timestamp;
//    }


    @Override
    public String toString() {
        return "Test{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", time='" + time + '\'' +
                '}';
    }

    public static void main(String[] args) {
        /*BasicConfigurator.configure();
        OOSpider.create(
                Site.me(),
                new ConsolePageModelPipeline(),
                Test.class)
//                .setDownloader(new SeleniumDownloader("E:/myData/IDE/git-graduate/graduate-idea/chromedriver.exe"))
                .addUrl("http://www.100ppi.com/sf/")
//                .thread(5)
                .run();*/

//        PropertyConfigurator.configure("log4j.properties");
//        System.setProperty("log4j.configuration", "./log4j.properties");
//        Logger logger = LoggerFactory.getLogger(Test.class);
//        logger.info("111,添加,用户");

//        System.out.println(new File("log.log").exists());

//        String s = "http://www.100ppi.com 2017年04月07日 16:30    来源：生意社";
//
//        int m = s.indexOf('m') + 1;
//        String ss = s.substring(m, m + 18);
//        System.out.println(m + "  " + ss);
    }
}
