package com.concurrent.handle.example.test08;

import com.concurrent.handle.example.test04.ThreadPoolUtil;

import java.util.concurrent.ExecutorService;

/**
 * Created by zhangwei on 2017/9/18.
 */
public class PessimisticLockTest {
    public static volatile int value = 0;//多线程并发操作对象

    /*
    * A线程执行的方法
    * */
    public static void invokeA(int valueA, String threadName) throws InterruptedException {
        Thread.sleep(2000);
        if (valueA != value) {
            System.out.println(threadName + " --A版本不一致，不执行");
        } else {
            valueA++;
            value = valueA;
            System.out.println("A操作后的值：" + value);
        }
    }

    /**
     * B线程执行的方法
     */
    public static void invokeB(int valueB, String threadName) throws InterruptedException {
        Thread.sleep(2000);
        if (valueB != value) {
            System.out.println(threadName + " --B版本不一致，不执行");
        } else {
            valueB--;
            value = valueB;
            System.out.println("B操作后的值：" + value);
        }
    }

    public static void main(String[] args) {
        ThreadPoolUtil threadPoolUtil = new ThreadPoolUtil();
        ExecutorService executorService = threadPoolUtil.getThreadPoolExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    PessimisticLockTest.invokeA(PessimisticLockTest.value, "a thread");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    PessimisticLockTest.invokeB(PessimisticLockTest.value, "b thread");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
