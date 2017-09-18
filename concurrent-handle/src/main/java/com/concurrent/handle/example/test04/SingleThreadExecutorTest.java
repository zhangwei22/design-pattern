package com.concurrent.handle.example.test04;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhangwei on 2017/9/18.
 */
public class SingleThreadExecutorTest {
    private static final Logger logger = LoggerFactory
            .getLogger(SingleThreadExecutorTest.class);

    public static void main(String[] args) {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            singleThreadExecutor.execute(new Runnable() {

                @Override
                public void run() {
                    logger.info("single do something..." + index);
                }
            });
        }
    }
}
