package thread.print.number;

import java.util.concurrent.locks.LockSupport;

public class Demo {
    public static Thread t1;
    public static Thread t2;

    public static void main(String[] args) {
        t1 = new Thread(() -> {
            for (int i = 1; i <= 100; i += 2) {
                System.out.println(i);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        });
        t2 = new Thread(() -> {
            for (int i = 2; i <= 100; i += 2) {
                LockSupport.park();
                System.out.println(i);
                LockSupport.unpark(t1);
            }
        });
        t1.start();
        t2.start();
    }
}
