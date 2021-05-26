package thread.join;

public class SubThread implements Runnable{
    private Thread parent;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" is starting");
        try {
            parent.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" end");
    }

    public Thread getParent() {
        return parent;
    }

    public void setParent(Thread parent) {
        this.parent = parent;
    }
}
