package com.thread.notify;

public class Queue {
    volatile String[] products;
    volatile int productNum = 0;

    public Queue(int size) {
        this.products = new String[size];
    }

    public boolean full(){
        return productNum == products.length;
    }

    public boolean blank(){
        return productNum== 0;
    }

    public void push(String productName){
        products[productNum++] = productName;
    }

    public String pop(){
        return products[--productNum];
    }
}
