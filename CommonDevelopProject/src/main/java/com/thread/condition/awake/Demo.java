package com.thread.condition.awake;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo {
    public static volatile int i = -1;
    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();

        for (int j = 0; j < 5; j++) {
            Thread t = new Thread(() ->{
                try {
                    lock.lock();
                    while (i==-1) {
                        try {
                            condition1.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    i++;
                    System.out.println(Thread.currentThread().getName()+" add 1: "+i);
                    if(i==5){
                        condition2.signalAll();
                    }
                }finally {
                    lock.unlock();
                }
            });
            t.start();
        }

        for (int j = 0; j < 5; j++) {
            Thread t = new Thread(() ->{
                try {
                    lock.lock();
                    while (i<5) {
                        try {
                            condition2.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    i = i+2;
                    System.out.println(Thread.currentThread().getName()+" add 2: "+i);
                }finally {
                    lock.unlock();
                }
            });
            t.start();
        }

        try {
            lock.lock();
            i = 0;
            condition1.signalAll();
        }finally {
            lock.unlock();
        }
    }
}
