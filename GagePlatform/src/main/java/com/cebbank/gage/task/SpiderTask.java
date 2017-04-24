package com.cebbank.gage.task;

import com.cebbank.gage.model.Mysteel;
import com.cebbank.gage.service.MysteelService;
import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.ConsolePageModelPipeline;
import us.codecraft.webmagic.model.OOSpider;

import java.util.Date;

/**
 * Created by xn on 2017/4/24.
 */
@Component
public class SpiderTask {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MysteelService myPipeline;

    @Scheduled(cron="0 0 1 ? * MON") //每周一1:00执行
    public void task(){
        logger.info("爬虫任务开始！ " + new Date());

        BasicConfigurator.configure();
        OOSpider.create(
                Site.me(),
                myPipeline,
                Mysteel.class)
                .addPageModel(new ConsolePageModelPipeline())
                .addUrl("http://www.100ppi.com/sf/")
                .thread(5)
                .run();

        logger.info("爬虫任务结束！ " + new Date());

    }
}
