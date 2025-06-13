package thread.print.letter;

import org.testng.annotations.Test;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

import static org.testng.Assert.*;

public class MutiThreadPrintBySemaphoreTest {

    @Test
    public void testRun() {
        Semaphore semaphore = new Semaphore(1);
        AtomicInteger stat = new AtomicInteger(0);
        MutiThreadPrintBySemaphore m1 = new MutiThreadPrintBySemaphore(semaphore, stat, 0, "A");
        MutiThreadPrintBySemaphore m2 = new MutiThreadPrintBySemaphore(semaphore, stat, 1, "B");
        MutiThreadPrintBySemaphore m3 = new MutiThreadPrintBySemaphore(semaphore, stat, 2, "C");
        new Thread(m1).start();
        new Thread(m2).start();
        new Thread(m3).start();
    }
}