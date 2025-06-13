package thread.print.letter;

import java.util.concurrent.BlockingQueue;

public class MutiThreadPrintByBlockingQueue implements Runnable {

    BlockingQueue<String> queue;

    BlockingQueue<String> nextQueue;

    String print;

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                queue.take();
                System.out.println(Thread.currentThread().getName() + " : " + print);
                nextQueue.offer("go");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public MutiThreadPrintByBlockingQueue(BlockingQueue<String> queue, BlockingQueue<String> nextQueue, String print) {
        this.queue = queue;
        this.nextQueue = nextQueue;
        this.print = print;
    }
}