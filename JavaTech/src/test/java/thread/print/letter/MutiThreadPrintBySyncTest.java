package thread.print.letter;

import org.testng.annotations.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class MutiThreadPrintBySyncTest {

    @Test
    public void testRun() {
        Object o = new Object();
        AtomicInteger stat = new AtomicInteger(0);
        MutiThreadPrintBySynchronized m1 = new MutiThreadPrintBySynchronized(o, stat, 0, "A");
        MutiThreadPrintBySynchronized m2 = new MutiThreadPrintBySynchronized(o, stat, 1, "B");
        MutiThreadPrintBySynchronized m3 = new MutiThreadPrintBySynchronized(o, stat, 2, "C");
        new Thread(m1).start();
        new Thread(m2).start();
        new Thread(m3).start();
    }
}