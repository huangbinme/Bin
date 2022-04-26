package thread.print.number;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo6 {

    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        Condition c1 = lock.newCondition();
        Condition c2 = lock.newCondition();
        Condition c3 = lock.newCondition();
        CountDownLatch l1 = new CountDownLatch(1), l2 = new CountDownLatch(1);
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 100; i += 3) {
                try {
                    lock.lock();
                    System.out.println(i);
                    l1.countDown();
                    c1.signalAll();
                    if (i != 100) c3.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                l1.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for (int i = 2; i <= 100; i += 3) {
                try {
                    lock.lock();
                    System.out.println(i);
                    l2.countDown();
                    c2.signalAll();
                    if (i != 98) c1.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                l1.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for (int i = 3; i <= 100; i += 3) {
                try {
                    lock.lock();
                    System.out.println(i);
                    c3.signalAll();
                    if (i != 99)c2.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }
}
