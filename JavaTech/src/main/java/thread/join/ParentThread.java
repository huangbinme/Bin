package thread.join;

public class ParentThread implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" is starting");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" end");
    }
}
