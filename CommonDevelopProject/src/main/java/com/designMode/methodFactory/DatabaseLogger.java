package com.designMode.methodFactory;

public class DatabaseLogger implements Logger{
    @Override
    public void printLog() {
        System.out.println("this is database logger");
    }
}
