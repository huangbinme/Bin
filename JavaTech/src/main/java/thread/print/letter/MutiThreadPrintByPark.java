package thread.print.letter;

import java.util.concurrent.locks.LockSupport;

public class MutiThreadPrintByPark implements Runnable {

    String print;

    Thread next;

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            LockSupport.park();
            System.out.println(print);
            LockSupport.unpark(next);
        }
    }

    public MutiThreadPrintByPark(String print) {
        this.print = print;
    }

    public void setNext(Thread next) {
        this.next = next;
    }
}