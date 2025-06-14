package thread.print.letter;

import java.util.concurrent.atomic.AtomicInteger;

public class MutiThreadPrintBySync implements Runnable {

    Object object;

    AtomicInteger stat;

    int workerId;

    String print;

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            synchronized (object) {
                while (stat.get() % 3 != workerId) {
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(Thread.currentThread().getName() + " : " + print);
                stat.incrementAndGet();
                object.notifyAll();
            }
        }
    }

    public MutiThreadPrintBySync(Object object, AtomicInteger stat, int workerId, String print) {
        this.object = object;
        this.stat = stat;
        this.workerId = workerId;
        this.print = print;
    }
}