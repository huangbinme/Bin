package thread.print.letter;

import org.testng.annotations.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MutiThreadPrintByBlockingQueueTest {

    @Test
    public void testRun() throws InterruptedException {
        BlockingQueue<String> q1 = new ArrayBlockingQueue<>(1);
        BlockingQueue<String> q2 = new ArrayBlockingQueue<>(1);
        BlockingQueue<String> q3 = new ArrayBlockingQueue<>(1);

        MutiThreadPrintByBlockingQueue m1 = new MutiThreadPrintByBlockingQueue(q1, q2, "A");
        MutiThreadPrintByBlockingQueue m2 = new MutiThreadPrintByBlockingQueue(q2, q3, "B");
        MutiThreadPrintByBlockingQueue m3 = new MutiThreadPrintByBlockingQueue(q3, q1, "C");
        Thread t1 = new Thread(m1);
        Thread t2 = new Thread(m2);
        Thread t3 = new Thread(m3);
        t1.start();
        t2.start();
        t3.start();
        q1.offer("go");
        t1.join();
        t2.join();
        t3.join();
    }
}