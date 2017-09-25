package com.concurrent.handle.example.test07;

import com.concurrent.handle.example.test04.ThreadPoolUtil;

import java.util.concurrent.ExecutorService;

/**
 * Created by zhangwei on 2017/9/18.
 */
public class DeadLockTest {

    static Object o1 = new Object(), o2 = new Object();

    public static void main(String[] args) {
        ThreadPoolUtil threadPoolUtil = new ThreadPoolUtil();
        ExecutorService pool = threadPoolUtil.getThreadPoolExecutor();
        for (int i = 0; i < 2; i++) {
            final int index = i;
            pool.execute(
                    new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("index = " + index);
                            if (index == 1) {
                                synchronized (o1) {
                                    try {
                                        Thread.sleep(500);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    synchronized (o2) {
                                        System.out.println("1");
                                    }
                                }
                            }
                            if (index == 0) {
                                synchronized (o2) {
                                    try {
                                        Thread.sleep(500);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    synchronized (o1) {
                                        System.out.println("0");
                                    }
                                }
                            }
                        }
                    }
            );
        }
    }
}
