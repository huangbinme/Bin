package thread.print.number;

public class Demo2 {
    public static void main(String[] args) {
        Object o = new Object();
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 100; i += 2) {
                synchronized (o) {
                    System.out.println(i);
                    o.notifyAll();
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 2; i <= 100; i += 2) {
                synchronized (o) {
                    System.out.println(i);
                    o.notifyAll();
                    if(i == 100) break;
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }
}
