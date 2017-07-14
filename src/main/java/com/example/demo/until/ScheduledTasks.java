package com.example.demo.until;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 陈 on 2017/7/10.
 */
@Component
@Configurable
@EnableScheduling
public class ScheduledTasks {
    @Autowired
    private QuartzProperties quartzProperties;

    @Value("${QuartzConfig.cronValue}")
    private String getCron;

    @Scheduled(fixedRate = 1000 * 30)
    public void reportCurrentTime(){
        System.out.println ("Scheduling Tasks Examples: The time is now " + dateFormat ().format (new Date ()));
    }

    //每1分钟执行一次
    //@Scheduled(cron = "0 */1 *  * * * ")
    final String cron="0/5 * * ? * *";
    @Scheduled(cron = "${QuartzConfig.cronValue}")
    public void reportCurrentByCron(){
        System.out.println(getCron);
        System.out.println(quartzProperties.getCronValue());
        quartzProperties.setCronValue("0/10 * *  * * * ");
        System.out.println ("Scheduling Tasks Examples By Cron: The time is now " + dateFormat ().format (new Date()));
    }
    @Scheduled(cron = "0 48 15 ? * *")
    public void change(){

        System.out.println ("eat " + dateFormat ().format (new Date()));
    }

    @Scheduled(cron = "0 0 12 ? * *")
    public void eat(){
        System.out.println ("eat " + dateFormat ().format (new Date()));
    }

    @Scheduled(cron = "0 0 13 ? * *")
    public void work(){
        System.out.println ("上班了!!!! " + dateFormat ().format (new Date()));
    }

    private SimpleDateFormat dateFormat(){
        return new SimpleDateFormat ("yyyy/MM/dd HH:mm:ss");
    }
}
