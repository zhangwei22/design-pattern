package com.concurrent.handle.example.test04;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhangwei on 2017/9/18.
 */
public class ScheduledThreadPoolTest {
    private static final Logger logger = LoggerFactory
            .getLogger(ScheduledThreadPoolTest.class);

    public static void main(String[] args) {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        scheduledThreadPool.schedule(new Runnable() {

            @Override
            public void run() {
                logger.info("scheduled do something...");
            }
        }, 3, TimeUnit.SECONDS);
    }
}
