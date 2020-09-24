package com.algorithm.find;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            list.add("hello"+i);
        }
        System.out.println(System.currentTimeMillis()-start);

        start = System.currentTimeMillis();
        List<String> list2 = new LinkedList<>();
        for (int i = 0; i < 1000000; i++) {
            list2.add("hello"+i);
        }
        System.out.println(System.currentTimeMillis()-start);
    }
}
