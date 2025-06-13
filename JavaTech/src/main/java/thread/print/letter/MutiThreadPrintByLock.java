package thread.print.letter;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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
                while (stat.get() != workerId) condition.await();
                System.out.println(print);
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

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition c = lock.newCondition();
        AtomicInteger stat = new AtomicInteger(0);
        MutiThreadPrintByLock m1 = new MutiThreadPrintByLock(lock, c, "A", stat, 0);
        MutiThreadPrintByLock m2 = new MutiThreadPrintByLock(lock, c, "B", stat, 1);
        MutiThreadPrintByLock m3 = new MutiThreadPrintByLock(lock, c, "C", stat, 2);
        Thread t1 = new Thread(m1);
        Thread t2 = new Thread(m2);
        Thread t3 = new Thread(m3);
        t1.start();
        t2.start();
        t3.start();
    }
}