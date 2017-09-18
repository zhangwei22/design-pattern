package com.decorate.web;

/**
 * Created by zhangwei on 2017/9/12.
 */
public class Person {
    public int age;
    public int height;
    public int weight;
    private String idCard;

    public void run(){
        System.out.println("I running");
    }

    public int getAge(){
        this.age = 24;
        return this.age;
    }

    public String intToStrTest(){
        Integer i = 23;
        String str = i.toString();
        String ss = "jsadfl;jjsadfjdls;fasdj";
        return str;
    }
}
