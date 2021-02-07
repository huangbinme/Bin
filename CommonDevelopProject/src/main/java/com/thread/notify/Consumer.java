package com.thread.notify;

import java.util.concurrent.TimeUnit;

public class Consumer extends Thread {
    private Queue queue;
    private int timeToProduceWithSeconds = 2;

    @Override
    public void run() {
        while (true) {
            consume();
        }
    }

    public void consume() {
        synchronized (queue) {
            if (queue.blank()) {
                waitToConsume(queue);
            } else {
                System.out.println(Thread.currentThread() + " is consuming " + queue.pop());
                notifyToProduce(queue);
            }
        }
        sleepToConsume(timeToProduceWithSeconds);
    }


    public void sleepToConsume(int time) {
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(time));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitToConsume(Object o) {
        try {
            o.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void notifyToProduce(Object o) {
        synchronized (o) {
            o.notifyAll();
        }
    }


    public Consumer(Queue queue) {
        this.queue = queue;
    }
}
