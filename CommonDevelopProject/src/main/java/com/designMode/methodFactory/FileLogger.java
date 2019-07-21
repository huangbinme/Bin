package com.designMode.methodFactory;

public class FileLogger implements Logger {
    @Override
    public void printLog() {
        System.out.println("This is file logger");
    }
}
