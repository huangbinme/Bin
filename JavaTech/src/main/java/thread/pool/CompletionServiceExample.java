package thread.pool;

import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CompletionServiceExample {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        ExecutorCompletionService<String> completionService = new ExecutorCompletionService<>(executorService);

        completionService.submit(() -> {
            Thread.sleep(1000);
            return "Task 1 done";
        });

        completionService.submit(() -> {
            Thread.sleep(3000);
            return "Task 2 done";
        });

        completionService.submit(() -> {
            Thread.sleep(3000);
            return "Task 3 done";
        });

        for (int i = 0; i < 3; i++) {
            Future<String> take = completionService.take();// 按任务完成的顺序取出结果
            System.out.println(take.get());
        }

        executorService.shutdown();
    }
}
