package thread.pool;

import java.util.concurrent.*;

public class ExecutorServiceExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 20; i++) {
            Runnable runnable = () -> {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + " is running");
            };
            executorService.execute(runnable);//提交任务，不带返回值

            Callable<String> callable = () -> Thread.currentThread().getName() + " is running";
            Future<String> future = executorService.submit(callable);//提交任务，带返回值
            System.out.println(future.get());
        }
        executorService.shutdown();
    }
}
