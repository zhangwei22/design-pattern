package com.concurrent.handle.example.test09;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by zhangwei on 2017/9/18.
 */
public class TimerConcurrentTest {

    public static void main(String[] args) {
        final TimerTask timerTask1 = new TimerTask() {
            @Override
            public void run() {
                System.out.println("task 1 is time up!");
                //throw new RuntimeException();
            }
        };
        final TimerTask timerTask2 = new TimerTask() {
            @Override
            public void run() {
                //System.out.println("task 2 is time up!");
                throw new RuntimeException();
            }
        };
        final TimerTask timerTask3 = new TimerTask() {
            @Override
            public void run() {
                System.out.println("task 3 is time up!");
            }
        };
        final TimerTask timerTask4 = new TimerTask() {
            @Override
            public void run() {
                System.out.println("task 4 is time up!");
            }
        };
        final TimerTask timerTask5 = new TimerTask() {
            @Override
            public void run() {
                System.out.println("task 5 is time up!");
            }
        };
        final TimerTask timerTask6 = new TimerTask() {
            @Override
            public void run() {
                System.out.println("task 6 is time up!");
            }
        };
        final TimerTask timerTask7 = new TimerTask() {
            @Override
            public void run() {
                System.out.println("task 7 is time up!");
            }
        };


        Timer timer = new Timer();
        timer.schedule(timerTask1, 1000);
        timer.schedule(timerTask2, 2000);
        timer.schedule(timerTask3, 1000);
        timer.schedule(timerTask4, 2000);
        timer.schedule(timerTask5, 1000);
        timer.schedule(timerTask6, 2000);
        timer.schedule(timerTask7, 1000);

        //timer.scheduleAtFixedRate(timerTask2, new Date(), 1000);
    }
}
