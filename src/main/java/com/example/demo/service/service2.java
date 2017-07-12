package com.example.demo.service;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by 陈 on 2017/7/10.
 */
public class service2 {
    public static void main(String[] args) throws Exception {
        //timer1();
//        timer2();
        //timer3();
//        timer4(new Date());
            String startDate="2017/7/10 13:07:00";
            timer5(startDate);
    }
    // 第一种方法：设定指定任务task在指定时间time执行 schedule(TimerTask task, Date time)
    public static void timer1() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                System.out.println("-------设定要指定任务--------");
            }
        }, 2000);// 设定指定的时间time,此处为2000毫秒
    }

    // 第二种方法：设定指定任务task在指定延迟delay后进行固定延迟peroid的执行
    // schedule(TimerTask task, long delay, long period)
    public static void timer2() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                System.out.println("-------设定要指定任务--------");
            }
        }, 1000, 5000);
    }

    // 第三种方法：设定指定任务task在指定延迟delay后进行固定频率peroid的执行。
    // scheduleAtFixedRate(TimerTask task, long delay, long period)
    public static void timer3() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                System.out.println("-------设定要指定任务--------");
            }
        }, 1000, 2000);
    }

    // 第四种方法：安排指定的任务task在指定的时间firstTime开始进行重复的固定速率period执行．
    // Timer.scheduleAtFixedRate(TimerTask task,Date firstTime,long period)
    public static void timer4(Date date) {
        System.out.println(date);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 11); // 控制时
        calendar.set(Calendar.MINUTE, 48);    // 控制分
        calendar.set(Calendar.SECOND, 0);    // 控制秒

        /*Date time = calendar.getTime();     // 得出执行任务的时间,此处为今天的12：00：00*/
        Date time = calendar.getTime();     // 得出执行任务的时间,此处为今天的12：00：00
        long period=1000 * 60 * 1;
        System.out.println(MessageFormat.format("定时任务启动时间:{0},周期为{1}分钟!",time,period/60000));
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                System.out.println("-------设定要指定任务--------");
                System.out.println(MessageFormat.format("-------当前时间:{0}--------",new Date()));
            }
        /*}, time, 1000 * 60 * 60 * 24);// 这里设定将延时每天固定执行*/
        }, time, period);// 这里设定将延时每天固定执行
    }

    // 第五种方法：设定指定任务task在指定指定开始时间后进行重复的固定速率peroid的执行。
    // scheduleAtFixedRate(TimerTask task, long delay, long period)
    public static void timer5(String startDate) throws Exception {
        Timer timer = new Timer();

        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = dateFormatter.parse(startDate);
        long period=1000 * 60 * 5 ; //间隔时间
        System.out.println(MessageFormat.format("定时任务启动时间:{0},周期为{1}分钟!",date,(float)period/60000));
        timer.schedule(new TimerTask() {
            private int count=0;
            public void run() {
                try {
                    count++;
                    if (count==5){
                        timer.cancel();
                        System.out.println("-------结束任务--------");
                    }
                    Thread.sleep(6000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("-------设定指定任务--------");
                System.out.println(MessageFormat.format("-------当前时间:{0}--------",new Date()));
            }
        }, date, period);
    }
}
