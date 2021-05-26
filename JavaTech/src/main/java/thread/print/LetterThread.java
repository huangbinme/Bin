package thread.print;

import java.util.concurrent.locks.Lock;

public class LetterThread implements Runnable{
    private Lock lock;
    private Printer printer;

    @Override
    public void run() {
        while (true){
            if(printer.getLetter()>25){
                printer.setOutputFlag(true);
                break;
            }

            if(!printer.isOutputFlag()){
                lock.lock();
                try {
                    printer.letterPrint();

                }finally {
                    printer.setOutputFlag(true);
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
