package com.basic;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaDateTime {
    public static void main(String[] args) {
//        LocalDateTime localDateTime = LocalDateTime.now();
//        LocalDateTime tmr = localDateTime.plusDays(1L);
        LocalDate localDate = LocalDate.now();
        int[] arr = {2, 8, 13, 11, 6, 7};
        List list = new ArrayList();
        System.out.println(localDate);
    }
}
