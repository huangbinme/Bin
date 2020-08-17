package com.design.factory;

public class DatabaseFactory implements Factory{
    @Override
    public Logger getLogger() {
        return new DatabaseLogger();
    }
}
