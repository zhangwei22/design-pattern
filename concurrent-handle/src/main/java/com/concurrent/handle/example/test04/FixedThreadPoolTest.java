package com.concurrent.handle.example.test04;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhangwei on 2017/9/18.
 */
public class FixedThreadPoolTest {
    private static final Logger logger = LoggerFactory
            .getLogger(FixedThreadPoolTest.class);

    public static void main(String[] args) {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            fixedThreadPool.execute(new Runnable() {

                @Override
                public void run() {
                    logger.info("fixed do something..." + index);
                }
            });
        }
    }
}
