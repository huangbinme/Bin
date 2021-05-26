package thread.lock.read;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Demo {
    public static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+" is start");

            try {
                reentrantReadWriteLock.writeLock().lock();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                reentrantReadWriteLock.writeLock().unlock();
            }
            System.out.println(Thread.currentThread().getName()+" is end");
        });

        Thread thread1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+" is start");
            try {
                reentrantReadWriteLock.writeLock().lock();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                reentrantReadWriteLock.writeLock().unlock();
            }
            System.out.println(Thread.currentThread().getName()+" is end");
        });

        thread.start();
        thread1.start();
    }
}
