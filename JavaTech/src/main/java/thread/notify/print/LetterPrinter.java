package thread.notify.print;

public class LetterPrinter extends Thread{
    Object object;

    @Override
    public void run() {
        while (true){
            synchronized (object){
                System.out.println("A");
                object.notify();
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public LetterPrinter(Object object) {
        this.object = object;
    }
}
