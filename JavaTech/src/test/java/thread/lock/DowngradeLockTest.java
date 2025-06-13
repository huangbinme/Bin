package thread.lock;

import org.testng.annotations.Test;

public class DowngradeLockTest {

    @Test
    public void testMain() {
        DowngradeLock downgradeLock = new DowngradeLock();
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                new Thread(() -> downgradeLock.plusOne()).start();
            } else {
                new Thread(() -> downgradeLock.print()).start();
            }
        }
    }
}