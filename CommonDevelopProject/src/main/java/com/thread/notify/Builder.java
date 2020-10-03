package com.thread.notify;

import java.util.ArrayList;
import java.util.List;

public class Builder {
    public static List<Producer> createProducer(int producerNum){
        List<Producer> producerList = new ArrayList<>();
        for (int i = 0; i < producerNum; i++) {
            producerList.add(new Producer());
        }
        return producerList;
    }

    public static List<Consumer> createConsumer(int consumerNum){
        List<Consumer> consumerList = new ArrayList<>();
        for (int i = 0; i < consumerNum; i++) {
            consumerList.add(new Consumer());
        }
        return consumerList;
    }

    public static ProductQueue createProductQueue(int fixedSize){
        ProductQueue productQueue = new ProductQueue(fixedSize);
        return productQueue;
    }
}
