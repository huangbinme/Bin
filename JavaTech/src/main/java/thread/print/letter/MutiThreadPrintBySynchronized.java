package thread.print.letter;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class MutiThreadPrintBySynchronized implements Runnable {

    Object object;

    AtomicInteger stat;

    int workerId;

    String print;

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            synchronized (object) {
                while (stat.get() % 3 != workerId) {
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(Thread.currentThread().getName() + " : " + print);
                stat.incrementAndGet();
                object.notifyAll();
            }
        }
    }

    public MutiThreadPrintBySynchronized(Object object, AtomicInteger stat, int workerId, String print) {
        this.object = object;
        this.stat = stat;
        this.workerId = workerId;
        this.print = print;
    }

    public static void main(String[] args) {
        Character[][] chars = new Character[3][3];
        System.out.println(chars[0][0]);
    }
}