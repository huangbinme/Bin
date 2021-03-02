package com;

import java.lang.reflect.Field;

public class Demo {
    int age = 1;

    public void add(){
        age++;
    }

    public static void main(String[] args) {
        Class c = Demo.class;
        Field[] fields = c.getDeclaredFields();
        Field fields1 = fields[0];
    }
}
