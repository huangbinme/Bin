package com.thread.notify;

import java.util.List;

public class Demo {
    public static void main(String[] args) {
        ProductQueue productQueue = Builder.createProductQueue(20);

        List<Consumer> consumerList = Builder.createConsumer(1);
        List<Producer> producerList = Builder.createProducer(10);

        consumerList.stream().forEach(consumer -> consumer.setProductQueue(productQueue));
        producerList.stream().forEach(producer -> producer.setProductQueue(productQueue));

        consumerList.stream().forEach(consumer -> {
            Thread thread = new Thread(consumer);
            thread.start();
        });
        producerList.stream().forEach(producer -> {
            Thread thread = new Thread(producer);
            thread.start();
        });
    }
}
