package thread.print.letter;

import java.util.concurrent.atomic.AtomicInteger;

public class MutiThreadPrintByAtomicInt implements Runnable {

    AtomicInteger stat;

    int workerId;

    String print;

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            while (stat.get() % 3 != workerId) {

            }
            System.out.println(Thread.currentThread().getName() + " : " + print);
            stat.incrementAndGet();
        }
    }

    public MutiThreadPrintByAtomicInt(AtomicInteger stat, int workerId, String print) {
        this.stat = stat;
        this.workerId = workerId;
        this.print = print;
    }
}
