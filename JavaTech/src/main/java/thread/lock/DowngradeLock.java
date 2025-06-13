package thread.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class DowngradeLock {

    volatile int i = 0;

    private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private static ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
    private static ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

    public void plusOne() {
        try {
            writeLock.lock();
            i++;
            readLock.lock();//获得写锁之后，降级成读锁
        } finally {
            writeLock.unlock();
        }
        try {
            System.out.println(Thread.currentThread().getName() + " " + "current i is : " + i);
        } finally {
            readLock.unlock();
        }

    }

    public void print() {
        try {
            readLock.lock();
            System.out.println(Thread.currentThread().getName() + " " + "current i is : " + i);
        } finally {
            readLock.unlock();
        }
    }
}
