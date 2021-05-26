package thread.print;

import java.util.concurrent.locks.LockSupport;

public class Demo3 {
    static Thread thread,thread2 = null;

    public static void main(String[] args) {
        Printer printer = new Printer();
        thread = new Thread(()-> {
            for (int i = 0; i < 26; i++) {
                printer.letterPrint();
                LockSupport.unpark(thread2);
                LockSupport.park();
            }
        });

        thread2 = new Thread(()-> {
            for (int i = 0; i < 26; i++) {
                LockSupport.park();
                printer.numberPrint();
                LockSupport.unpark(thread);

            }
        });

        thread.start();
        thread2.start();
    }
}
