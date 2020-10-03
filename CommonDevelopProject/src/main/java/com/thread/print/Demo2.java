package com.thread.print;

public class Demo2 {
    public static void main(String[] args) {
        Printer printer = new Printer();

        Runnable runnable = () -> {
            int count = 26;

            synchronized (printer) {
                for (int i = 0; i < count; i++) {
                    printer.numberPrint();
                    try {
                        printer.notify();
                        printer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                printer.notify();
            }
        };

        Runnable runnable2 = () -> {
            int count = 26;
            synchronized (printer) {
                for (int i = 0; i < count; i++) {
                    printer.letterPrint();
                    try {
                        printer.notify();
                        printer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                printer.notify();
            }
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable2);
        t1.start();
        t2.start();
    }
}
