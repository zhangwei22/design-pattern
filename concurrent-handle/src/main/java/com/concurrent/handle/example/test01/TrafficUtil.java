package com.concurrent.handle.example.test01;

/**
 * Created by zhangwei on 2017/9/18.
 */
public class TrafficUtil {
    private volatile static Car car;

    TrafficUtil() {
    }

    public static Car getCar() {
        if (car == null) {
            synchronized (TrafficUtil.class) {
                if (car == null) {
                    car = new Car();
                }
            }
        }
        return car;
    }

    public static void main(String[] args) {
        Car car = TrafficUtil.getCar();
        car.run();
    }
}
