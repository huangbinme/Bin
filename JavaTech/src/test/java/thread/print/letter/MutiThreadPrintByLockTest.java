package thread.print.letter;

import org.testng.annotations.Test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MutiThreadPrintByLockTest {

    @Test
    public void test1() {
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