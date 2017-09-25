package com.concurrent.handle.example.test01;

/**
 * Created by zhangwei on 2017/9/18.
 */
public class CarSingleton {
    private volatile static CarSingleton carSingleton;

    private CarSingleton() {
    }

    public static CarSingleton getCarSingleton() {
        if (carSingleton == null) {
            synchronized (CarSingleton.class) {
                if (carSingleton == null) {
                    carSingleton = new CarSingleton();
                }
            }
        }
        return carSingleton;
    }

    public void run() {
        System.out.println("go go...");
    }
}
