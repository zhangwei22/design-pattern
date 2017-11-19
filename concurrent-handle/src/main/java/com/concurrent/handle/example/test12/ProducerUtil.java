package com.concurrent.handle.example.test12;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zhangwei on 2017/9/21.
 */
public class ProducerUtil {
    private volatile static ProducerUtil producerUtil;

    private ProducerUtil() {
    }

    public static ProducerUtil getProducer() {
        if (producerUtil == null) {
            synchronized (ProducerUtil.class) {
                if (producerUtil == null) {
                    producerUtil = new ProducerUtil();
                }
            }
        }
        AtomicInteger a = new AtomicInteger();
        return producerUtil;
    }
}
