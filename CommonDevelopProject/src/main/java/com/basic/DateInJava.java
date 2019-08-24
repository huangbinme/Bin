package com.basic;

import java.time.LocalDateTime;

public class DateInJava {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime tmr = localDateTime.plusDays(1L);
        System.out.println(tmr);
    }
}
