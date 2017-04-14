package com.cebbank.gage.spider;

import org.apache.log4j.BasicConfigurator;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * Created by xn on 2017/4/10.
 */
public class HuabanProcessor implements PageProcessor {

    private Site site;

    public void process(Page page) {
        page.addTargetRequests(page.getHtml().links().regex("http://huaban\\.com/.*").all());
        if (page.getUrl().toString().contains("pins")) {
            page.putField("img", page.getHtml().xpath("//div[@class='image-holder']/a/img/@src").toString());
        } else {
            page.getResultItems().setSkip(true);
        }
    }

    public Site getSite() {
        if (null == site) {
            site = Site.me().setDomain("huaban.com").setSleepTime(0);
        }
        return site;
    }

    public static void main(String[] args) {
        BasicConfigurator.configure();
        Spider.create(new HuabanProcessor()).thread(5)
                .addPipeline(new ConsolePipeline())
                .setDownloader(new SeleniumDownloader("E:/myData/IDE/git-graduate/graduate-idea/chromedriver.exe"))
                .addUrl("http://huaban.com/")
                .runAsync();
    }
}
