package com.designMode.methodFactory;

public class DatabaseFactory implements Factory{
    @Override
    public Logger getLogger() {
        return new DatabaseLogger();
    }
}
