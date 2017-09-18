package com.concurrent.handle.example.test09;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by zhangwei on 2017/9/18.
 */
public class TimerTest {
    Timer timer;

    public TimerTest(int second) {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Time is up !" + System.currentTimeMillis());
                timer.cancel();//终止Timer
            }
        }, second * 1000);
    }

    public static void main(String[] args) {
        System.out.println("begin timer test..." + System.currentTimeMillis());
        new TimerTest(5);
        System.out.println("end timer test.." + System.currentTimeMillis());
    }
}
