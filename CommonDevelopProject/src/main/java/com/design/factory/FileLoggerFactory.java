package com.design.factory;

public class FileLoggerFactory implements Factory{
    @Override
    public Logger getLogger() {
        return new FileLogger();
    }
}
