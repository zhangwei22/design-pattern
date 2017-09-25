package com.concurrent.handle.example.test04;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhangwei on 2017/9/18.
 */
public class ThreadPoolUtil {
    private static final Logger logger = LoggerFactory
            .getLogger(ThreadPoolUtil.class);

    private ThreadPoolExecutor threadPoolExecutor = null;

    /**
     * Param:
     * corePoolSize - 池中所保存的线程数，包括空闲线程。
     * maximumPoolSize - 池中允许的最大线程数(采用LinkedBlockingQueue时没有作用)。
     * keepAliveTime -当线程数大于核心时，此为终止前多余的空闲线程等待新任务的最长时间，线程池维护线程所允许的空闲时间。
     * unit - keepAliveTime参数的时间单位，线程池维护线程所允许的空闲时间的单位:秒 。
     * workQueue - 执行前用于保持任务的队列（缓冲队列）。此队列仅保持由execute 方法提交的 Runnable 任务。
     * RejectedExecutionHandler -线程池对拒绝任务的处理策略(重试添加当前的任务，自动重复调用execute()方法)
     *
     * http://blog.csdn.net/xtwolf008/article/details/7343233
     */
    public ThreadPoolUtil() {
        threadPoolExecutor = new ThreadPoolExecutor(10, 30, 30, TimeUnit.SECONDS, new ArrayBlockingQueue(10),
                new ThreadPoolExecutor.DiscardOldestPolicy());
    }

    public ExecutorService getThreadPoolExecutor() {
        return this.threadPoolExecutor;
    }

    public static void main(String[] args) {
        /**
         new Thread的弊端如下：

         a. 每次new Thread新建对象性能差。
         b. 线程缺乏统一管理，可能无限制新建线程，相互之间竞争，及可能占用过多系统资源导致死机或oom。
         c. 缺乏更多功能，如定时执行、定期执行、线程中断。
         相比new Thread，Java提供的四种线程池的好处在于：
         a. 重用存在的线程，减少对象创建、消亡的开销，性能佳。
         b. 可有效控制最大并发线程数，提高系统资源的使用率，同时避免过多资源竞争，避免堵塞。
         c. 提供定时执行、定期执行、单线程、并发数控制等功能。
         */

        ThreadPoolUtil threadPoolUtil = new ThreadPoolUtil();
        ExecutorService pool = threadPoolUtil.getThreadPoolExecutor();
        for (int i = 0; i < 10; i++) {
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    logger.info("do something...");
                }
            });
        }
        System.out.println("run end!");
    }
}
