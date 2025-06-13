package thread.print.letter;

import org.testng.annotations.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.testng.Assert.*;

public class MutiThreadPrintBySyncTest {

    @Test
    public void testRun() {
        Object o = new Object();
        AtomicInteger stat = new AtomicInteger(0);
        MutiThreadPrintBySync m1 = new MutiThreadPrintBySync(o, stat, 0, "A");
        MutiThreadPrintBySync m2 = new MutiThreadPrintBySync(o, stat, 1, "B");
        MutiThreadPrintBySync m3 = new MutiThreadPrintBySync(o, stat, 2, "C");
        new Thread(m1).start();
        new Thread(m2).start();
        new Thread(m3).start();
    }
}