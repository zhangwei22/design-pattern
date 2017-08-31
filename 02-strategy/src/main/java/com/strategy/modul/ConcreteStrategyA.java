package com.strategy.modul;

/**
 * Created by zhangwei on 17/8/31.
 */
public class ConcreteStrategyA implements Strategy {
    @Override
    public void AlgorithmInterface() {
        System.out.println("算法A实现策略");
    }
}
