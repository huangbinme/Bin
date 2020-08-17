package com.design.factory;

public class DatabaseLogger implements Logger{
    @Override
    public void printLog() {
        System.out.println("this is database logger");
    }
}
