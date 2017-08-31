package com.decorate.modul;

/**
 * Created by zhangwei on 17/8/31.
 */
public class Finery extends Person {
    protected Person conponent;

    public void decorate(Person conponent) {
        this.conponent = conponent;
    }

    @Override
    public void show() {
        if (conponent != null) {
            conponent.show();
        }
    }
}
