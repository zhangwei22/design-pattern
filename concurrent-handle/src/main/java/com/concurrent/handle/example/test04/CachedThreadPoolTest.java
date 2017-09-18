package com.concurrent.handle.example.test04;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhangwei on 2017/9/18.
 */
public class CachedThreadPoolTest {
    private static final Logger logger = LoggerFactory
            .getLogger(CachedThreadPoolTest.class);

    public static void main(String[] args) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            cachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    logger.info("cached do something..." + index);
                }
            });
        }
    }
}
