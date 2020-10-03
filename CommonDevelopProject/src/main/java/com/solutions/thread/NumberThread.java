package com.solutions.thread;

import java.util.concurrent.locks.Lock;

public class NumberThread implements Runnable{
    private Lock lock;
    private Printer printer;

    @Override
    public void run() {
        while (true){
            if(printer.getNumber()>25){
                break;
            }

            if(printer.isOutputFlag()){
                lock.tryLock();

                try {
                    printer.numberPrint();
                }finally {
                    lock.unlock();
                    printer.setOutputFlag(false);
                }
            }else {

            }
        }
    }

    public Lock getLock() {
        return lock;
    }

    public void setLock(Lock lock) {
        this.lock = lock;
    }

    public Printer getPrinter() {
        return printer;
    }

    public void setPrinter(Printer printer) {
        this.printer = printer;
    }
}
