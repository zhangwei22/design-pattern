package com.concurrent.handle.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhangwei on 2017/9/21.
 */
public class ThreadPoolExecutorUtil {

    private static volatile ThreadPoolExecutor threadPoolExecutor;

    private ThreadPoolExecutorUtil() {
    }

    public static ThreadPoolExecutor getThreadPoolExecutor() {
        if (threadPoolExecutor == null) {
            synchronized (ThreadPoolExecutorUtil.class) {
                if (threadPoolExecutor == null) {
                    threadPoolExecutor = new ThreadPoolExecutor(10, 30, 30, TimeUnit.SECONDS,
                            new ArrayBlockingQueue(10),
                            new ThreadPoolExecutor.DiscardOldestPolicy());
                }
            }
        }
        return threadPoolExecutor;
    }

}
