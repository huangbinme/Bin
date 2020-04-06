package com.design.methodFactory;

public class FileLoggerFactory implements Factory{
    @Override
    public Logger getLogger() {
        return new FileLogger();
    }
}