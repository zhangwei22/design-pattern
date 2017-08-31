package com.decorate.modul;

import javax.sound.midi.Soundbank;

/**
 * Created by zhangwei on 17/8/31.
 */
public class Person {
    public Person() {

    }

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println("装饰的" + name);
    }
}
