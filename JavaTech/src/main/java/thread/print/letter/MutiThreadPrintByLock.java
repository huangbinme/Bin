package thread.print.letter;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class MutiThreadPrintByLock implements Runnable {

    Lock lock;

    Condition condition;

    String print;

    AtomicInteger stat;

    int workerId;

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                lock.lock();
                while (stat.get() % 3 != workerId) {
                    condition.await();
                }
                System.out.println(Thread.currentThread().getName() + " : " + print);
                stat.incrementAndGet();
                condition.signalAll();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }

    }

    public MutiThreadPrintByLock(Lock lock, Condition condition, String print, AtomicInteger stat, int workerId) {
        this.lock = lock;
        this.condition = condition;
        this.print = print;
        this.stat = stat;
        this.workerId = workerId;
    }
}