package thread.print.letter;

import org.testng.annotations.Test;

import java.util.concurrent.locks.LockSupport;

import static org.testng.Assert.*;

public class MutiThreadPrintByParkTest {

    @Test
    public void testRun() throws InterruptedException {
        MutiThreadPrintByPark m1 = new MutiThreadPrintByPark("A");
        MutiThreadPrintByPark m2 = new MutiThreadPrintByPark("B");
        MutiThreadPrintByPark m3 = new MutiThreadPrintByPark("C");
        Thread t1 = new Thread(m1);
        Thread t2 = new Thread(m2);
        Thread t3 = new Thread(m3);
        m1.setNext(t2);
        m2.setNext(t3);
        m3.setNext(t1);
        t1.start();
        t2.start();
        t3.start();
        Thread.sleep(100);
        LockSupport.unpark(t1);
    }
}