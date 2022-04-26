package thread.print.number;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo3 {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        CountDownLatch count = new CountDownLatch(1);
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 100; i += 2) {
                try {
                    lock.lock();
                    System.out.println(i);
                    count.countDown();
                    condition.signalAll();
                    condition.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                count.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for (int i = 2; i <= 100; i += 2) {
                try {
                    lock.lock();
                    System.out.println(i);
                    condition.signalAll();
                    if (i != 100) condition.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        });
        t1.start();
        t2.start();
    }
}
