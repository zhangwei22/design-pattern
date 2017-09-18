package com.concurrent.handle.example.test06;

/**
 * Created by zhangwei on 2017/9/18.
 */
public class MinLock {

    /*synchronized修饰非静态方法、同步代码块的synchronized (this)用法和synchronized (非this对象)的用法锁的是对象，线程想要执行对应同步代码，需要获得对象锁。
    synchronized修饰静态方法以及同步代码块的synchronized (类.class)用法锁的是类，线程想要执行对应同步代码，需要获得类锁。*/

    static Object object = new Object();

    synchronized public void getValue() {//锁的是对象
        System.out.println("get value...");
    }

    synchronized public static void getHandle() {//锁的是类
        System.out.println("get handle...");
    }

    public void doHandle() {
        try {
            synchronized (this) {//锁的是对象
                System.out.println("begin do handle " + System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("end do handle " + System.currentTimeMillis());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doHandle2() {
        try {
            synchronized (object) {//锁的是对象
                System.out.println("begin do handle2 " + System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("end do handle2 " + System.currentTimeMillis());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void lockClassTest(){//锁的是类
        synchronized (MinLock.class){
            System.out.println("lock class test...");
        }
    }
}
