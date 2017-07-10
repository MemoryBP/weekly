package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeeklyApplicationTests {

	@Test
	public void contextLoads() {

		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		/*Date startdata = simpleDateFormat.parse("2017/07/07 13:43:00");*/
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				// task to run goes here
				System.out.println("Hello !!!");
			}
		};
		Timer timer = new Timer();
		long delay = 30;

		long intevalPeriod = 3 * 1000;
		// schedules the task to be run in an interval
		timer.scheduleAtFixedRate(task, 500, intevalPeriod);
	}

}
