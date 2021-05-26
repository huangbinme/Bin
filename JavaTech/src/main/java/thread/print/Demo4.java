package thread.print;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

public class Demo4 {
    public static AtomicInteger atomicInteger = new AtomicInteger(1);
    public static CountDownLatch countDownLatch = new CountDownLatch(2);
    public static Thread t1;
    public static Thread t2;
    public static Thread t3;

    public static void main(String[] args) throws InterruptedException {
        t1 = new Thread(() ->{
            boolean init = false;
            while (true){
                int num = atomicInteger.get();
                if(num%3==0&&num<=100){
                    atomicInteger.addAndGet(1);
                    System.out.println(Thread.currentThread().getName() + " : ["+num+"]");
                }
                if(num>100){
                    break;
                }else {
                    LockSupport.unpark(t2);
                    if(!init){
                        countDownLatch.countDown();
                        init = true;
                    }
                    LockSupport.park();
                }
            }
        });

        t2 = new Thread(() ->{
            while (true){
                boolean init = false;
                int num = atomicInteger.get();
                if(num%5==0&&num<=100){
                    atomicInteger.addAndGet(1);
                    System.out.println(Thread.currentThread().getName() + " : ["+num+"]");
                }
                if(num>100){
                    break;
                }else {
                    LockSupport.unpark(t3);
                    if(!init){
                        countDownLatch.countDown();
                        init = true;
                    }
                    LockSupport.park();
                }
            }
        });

        t3 = new Thread(() ->{
            while (true){
                boolean init = false;
                if(!init){
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int num = atomicInteger.get();
                if(num%5!=0&&num%3!=0&&num<=100){
                    atomicInteger.addAndGet(1);
                    System.out.println(Thread.currentThread().getName() + " : ["+num+"]");
                }
                if(num>100){
                    LockSupport.unpark(t1);
                    LockSupport.unpark(t2);
                    break;
                }else {
                    LockSupport.unpark(t1);
                    LockSupport.park();
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }
}
