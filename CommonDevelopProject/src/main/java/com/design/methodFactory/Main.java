package com.design.methodFactory;

public class Main {
    public static void main(String[] args) {
        Factory factory;
        Factory factory1;

        factory = new DatabaseFactory();
        factory1 = new FileLoggerFactory();

        Logger logger;
        Logger logger1;

        logger = factory.getLogger();
        logger1 = factory1.getLogger();

        logger.printLog();
        logger1.printLog();
    }
}
