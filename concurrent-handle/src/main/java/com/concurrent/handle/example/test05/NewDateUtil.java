package com.concurrent.handle.example.test05;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by zhangwei on 2017/9/18.
 */
public class NewDateUtil {

    public static void main(String[] args) {
        Instant instant = Instant.now();
        System.out.println(instant);

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        String text = localDate.format(dateTimeFormatter);
        System.out.println(text);
        LocalDate parseDate = LocalDate.parse(text, dateTimeFormatter);
    }
}
