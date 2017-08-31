package com.strategy.web;

import com.strategy.modul.Strategy;

/**
 * Created by zhangwei on 17/8/31.
 */
public class Context {
    Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void ContextInterface() {
        strategy.AlgorithmInterface();
    }
}
