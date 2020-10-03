package com.thread.print;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Lock lock = new ReentrantLock();

        LetterThread run1 = new LetterThread();
        run1.setLock(lock);
        run1.setPrinter(printer);

        NumberThread run2 = new NumberThread();
        run2.setLock(lock);
        run2.setPrinter(printer);

        Thread letterThread = new Thread(run1);
        Thread numberThread = new Thread(run2);
        numberThread.start();
        letterThread.start();
    }
}
