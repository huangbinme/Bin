package com.thread.cas;

import java.util.concurrent.CountDownLatch;

public class Demo {
    public static AddingNumber addingNumber = new AddingNumber();

    public static void main(String[] args) throws InterruptedException {
        int theadNum = 10000;
        CountDownLatch countDownLatch = new CountDownLatch(theadNum);
        AddingNumber addingNumber = new AddingNumber();
        for (int i = 0; i < theadNum; i++) {
            Thread thread = new Thread(() -> {
                addingNumber.add();
                countDownLatch.countDown();
            });
            thread.start();
        }
        countDownLatch.await();
        System.out.println(addingNumber.get());
    }
}
