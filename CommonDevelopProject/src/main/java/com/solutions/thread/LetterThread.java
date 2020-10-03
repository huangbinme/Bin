package com.solutions.thread;

import java.util.concurrent.locks.Lock;

public class LetterThread implements Runnable{
    private Lock lock;
    private Printer printer;

    @Override
    public void run() {
        while (true){
            if(printer.getLetter()>25){
                break;
            }

            if(!printer.isOutputFlag()){
                lock.tryLock();

                try {
                    printer.letterPrint();
                }finally {
                    lock.unlock();
                    printer.setOutputFlag(true);
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
