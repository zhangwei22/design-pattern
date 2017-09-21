package com.concurrent.handle.example.test11;

import com.concurrent.handle.example.test04.ThreadPoolUtil;

import java.util.Random;
import java.util.concurrent.ExecutorService;

/**
 * Created by zhangwei on 2017/9/21.
 */
public class ThreadRandomTest {

    public static void main(String[] args) {
        ThreadPoolUtil threadPoolUtil = new ThreadPoolUtil();
        ExecutorService executorService = threadPoolUtil.getThreadPoolExecutor();
        for (int i = 0; i < 10; i++) {
            int index = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        int ran = new Random().nextInt();
                        ran++;
                        System.out.println("random value " + index + ":" + ran);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
