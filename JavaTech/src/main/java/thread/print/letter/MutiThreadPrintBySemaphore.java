package thread.print.letter;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class MutiThreadPrintBySemaphore implements Runnable {

    Semaphore semaphore;

    AtomicInteger stat;

    int workerId;

    String print;

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                semaphore.acquire();
                while (stat.get() % 3 != workerId) {
                    semaphore.release();
                }
                System.out.println(Thread.currentThread().getName() + " : " + print);
                stat.incrementAndGet();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                semaphore.release();
            }
        }
    }

    public MutiThreadPrintBySemaphore(Semaphore semaphore, AtomicInteger stat, int workerId, String print) {
        this.semaphore = semaphore;
        this.stat = stat;
        this.workerId = workerId;
        this.print = print;
    }
}