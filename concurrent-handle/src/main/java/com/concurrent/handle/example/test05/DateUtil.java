package com.concurrent.handle.example.test05;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhangwei on 2017/9/18.
 */
public class DateUtil {
    public static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) DateUtil.df.get();
        System.out.println(simpleDateFormat.format(date));
    }
}
