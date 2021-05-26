package thread.condition.consumer;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo {
    public static void main(String[] args) {
        Queue queue = new Queue(10);

        Lock lock = new ReentrantLock();
        Producer p1 = new Producer(lock,queue);
        Producer p2 = new Producer(lock,queue);
        Producer p3 = new Producer(lock,queue);

        Consumer c1 = new Consumer(lock,queue);
        Consumer c2 = new Consumer(lock,queue);
        Consumer c3 = new Consumer(lock,queue);

        p1.start();
        p2.start();
        p3.start();
        c1.start();
        c2.start();
        c3.start();
    }
}
