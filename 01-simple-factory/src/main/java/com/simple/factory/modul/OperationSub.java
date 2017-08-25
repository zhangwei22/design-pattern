package com.simple.factory.modul;

/**
 * Created by zhangwei on 17/8/25.
 */
public class OperationSub extends Operation {

    @Override
    public Double getResult(Double _numberA, Double _numberB) {
        double result = _numberA - _numberB;
        return result;
    }
}
