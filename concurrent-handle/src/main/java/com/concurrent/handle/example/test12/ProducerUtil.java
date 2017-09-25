package com.concurrent.handle.example.test12;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zhangwei on 2017/9/21.
 */
public class ProducerUtil {
    private volatile static Producer producer;

    private ProducerUtil() {
    }

    public static Producer getProducer() {
        if (producer == null) {
            synchronized (ProducerUtil.class) {
                if (producer == null) {
                    producer = new Producer();
                }
            }
        }
        AtomicInteger a = new AtomicInteger();
        return producer;
    }
}
