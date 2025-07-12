package com;

import java.util.concurrent.locks.LockSupport;

public class Solution {
    static class Fibo {
        volatile int a = 1;
        volatile int b = 1;

        public int getNext() {
            int ans = a;
            int sum = a + b;
            a = b;
            b = sum;
            return ans;
        }
    }

    static class Printer implements Runnable {
        Fibo fibo;
        Thread next;
        int printCount = 3;

        @Override
        public void run() {
            for (int i = 0; i < printCount; i++) {
                LockSupport.park();
                System.out.println(Thread.currentThread().getName() + " print : " + fibo.getNext());
                LockSupport.unpark(next);
            }
        }

        public Printer(Fibo fibo) {
            this.fibo = fibo;
        }

        public void setNext(Thread next) {
            this.next = next;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Fibo fibo = new Fibo();
        Printer p1 = new Printer(fibo);
        Printer p2 = new Printer(fibo);
        Printer p3 = new Printer(fibo);
        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p2);
        Thread t3 = new Thread(p3);
        p1.setNext(t2);
        p2.setNext(t3);
        p3.setNext(t1);
        t1.start();
        t2.start();
        t3.start();
        Thread.sleep(500);
        LockSupport.unpark(t1);
    }
}
