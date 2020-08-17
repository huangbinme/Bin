package com.design.factory;

public class FileLogger implements Logger {
    @Override
    public void printLog() {
        System.out.println("This is file logger");
    }
}
