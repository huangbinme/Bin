package thread.print.number;

public class Demo4 {

    private static volatile boolean flag = true;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 100; i += 2) {
                while (!flag);
                System.out.println(i);
                flag = false;
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 2; i <= 100; i += 2) {
                while (flag);
                System.out.println(i);
                flag = true;
            }
        });
        t1.start();
        t2.start();
    }
}
