package thread.condition.consumer;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Producer extends Thread {
    private Lock lock;
    private int timeToProcessWithSeconds = 2;
    private Queue queue;
    private Condition condition;

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                while (queue.full()) {
                    condition.await();
                }
                System.out.println(Thread.currentThread() + " is creating product");
                queue.push("Product");
                condition.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            sleepInterval();
        }
    }

    private void sleepInterval() {
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(timeToProcessWithSeconds));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Producer(Lock lock, Queue queue) {
        this.lock = lock;
        this.queue = queue;
        this.condition = lock.newCondition();
    }

    public Lock getLock() {
        return lock;
    }

    public void setLock(Lock lock) {
        this.lock = lock;
    }
}
