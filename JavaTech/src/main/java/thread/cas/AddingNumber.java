package thread.cas;

import java.util.concurrent.atomic.AtomicReference;

public class AddingNumber {
    int i = 0;
    private final AtomicReference<Integer> atomicReference = new AtomicReference(0);

    public void add(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (;;) {
            Integer a = atomicReference.get();
            if (atomicReference.compareAndSet(a,a+1)){
                break;
            }
        }
    }

    public int get(){
        return atomicReference.get().intValue();
    }

    public void add1(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        i++;
    }

    public int get1(){
        return i;
    }
}
