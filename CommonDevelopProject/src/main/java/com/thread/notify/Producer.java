package com.thread.notify;

import java.util.concurrent.TimeUnit;

public class Producer extends Thread {
    private Queue queue;
    private int timeToProduceWithSeconds = 1;

    @Override
    public void run() {
        while (true) {
            produce();
        }
    }

    public void produce() {
        synchronized (queue) {
            if (queue.full()) {
                waitToProduce(queue);
            } else {
                System.out.println(Thread.currentThread() + " is creating product");
                queue.push("Product");
                notifyToConsume(queue);
            }
        }
        sleepToProduce(timeToProduceWithSeconds);
    }

    private void notifyToConsume(Object o) {
        o.notifyAll();
    }

    public void sleepToProduce(int time) {
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(time));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitToProduce(Object o) {
        try {
            o.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Producer(Queue queue) {
        this.queue = queue;
    }
}
