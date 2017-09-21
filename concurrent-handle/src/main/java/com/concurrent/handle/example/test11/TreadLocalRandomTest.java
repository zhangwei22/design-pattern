package com.concurrent.handle.example.test11;

import com.concurrent.handle.example.test04.ThreadPoolUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by zhangwei on 2017/9/21.
 */
public class TreadLocalRandomTest {

    public static void main(String[] args){
        ThreadPoolUtil threadPoolUtil = new ThreadPoolUtil();
        ExecutorService executorService = threadPoolUtil.getThreadPoolExecutor();
        for (int i = 0; i < 10; i++) {
            int index = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        int ran = ThreadLocalRandom.current().nextInt();
                        ran++;
                        System.out.println("random value " + index + ": " + ran);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
