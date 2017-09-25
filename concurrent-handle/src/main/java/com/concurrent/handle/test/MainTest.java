package com.concurrent.handle.test;

import com.concurrent.handle.example.test04.ThreadPoolUtil;

import java.util.concurrent.ExecutorService;

/**
 * Created by zhangwei on 2017/9/21.
 */
public class MainTest {
    public static void main(String[] args) {
        ThreadPoolUtil threadPoolUtil = new ThreadPoolUtil();
        ExecutorService executorService = threadPoolUtil.getThreadPoolExecutor();
        for (int i = 0; i < 1000; i++) {
            int index = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("begin " + index);
                    ExecutorService executorService1 = ThreadPoolExecutorUtil.getThreadPoolExecutor();
                    executorService1.execute(new Runnable() {
                        @Override
                        public void run() {
                            computeHandle(index);
                        }
                    });
                    System.out.println("end "+index);
                }
            });
        }
    }

    public static void computeHandle(int id) {
        System.out.println("handle id: " + id);
    }
}
