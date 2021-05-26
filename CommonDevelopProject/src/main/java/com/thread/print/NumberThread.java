package com.thread.print;

import java.util.concurrent.locks.Lock;

public class NumberThread implements Runnable{
    private Lock lock;
    private Printer printer;

    @Override
    public void run() {
        while (true){
            if(printer.getNumber()>26){
                printer.setOutputFlag(false);
                break;
            }

            if(printer.isOutputFlag()){
                lock.lock();
                try {
                    printer.numberPrint();
                }finally {
                    printer.setOutputFlag(false);
                    lock.unlock();
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
