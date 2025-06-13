package thread.print.letter;

import org.testng.annotations.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.testng.Assert.*;

public class MutiThreadPrintByAtomicIntTest {

    @Test
    public void testRun() {
        AtomicInteger stat = new AtomicInteger(0);
        MutiThreadPrintByAtomicInt m1 = new MutiThreadPrintByAtomicInt(stat,0,"A");
        MutiThreadPrintByAtomicInt m2 = new MutiThreadPrintByAtomicInt(stat,1,"B");
        MutiThreadPrintByAtomicInt m3 = new MutiThreadPrintByAtomicInt(stat,2,"C");
        new Thread(m1).start();
        new Thread(m2).start();
        new Thread(m3).start();
    }
}