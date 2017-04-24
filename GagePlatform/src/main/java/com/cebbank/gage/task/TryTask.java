package com.cebbank.gage.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by xn on 2017/4/24.
 */
@Component
public class TryTask {

    @Scheduled(cron="0/5 * * * * ? ") //间隔5秒执行
    public void task(){
        System.out.println("=====================  " + new Date());
    }
}
