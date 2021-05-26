package com.thread.notify.print;

public class NumberPrinter extends Thread{
    Object object;

    @Override
    public void run() {
        while (true){
            synchronized (object){
                System.out.println("1");
                object.notify();
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public NumberPrinter(Object object) {
        this.object = object;
    }
}
