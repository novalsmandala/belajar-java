package noval.surya.mandala.thread;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.*;

public class CompletionServiceTest {

    private Random random = new Random();

    @Test
    void test() throws InterruptedException {

        var executor = Executors.newFixedThreadPool(10);
        var completionService = new ExecutorCompletionService<String>(executor);

        // submit task
        Executors.newSingleThreadExecutor().execute(() -> {
            for (int i = 0; i < 100; i++) {
                final var index = i;
                completionService.submit(() -> {
                    Thread.sleep(random.nextInt(2000));
                    return "Task " + index;
                });
            }
        });

        Executors.newSingleThreadExecutor().execute(() -> {
            while (true){
                try {
                    Future<String> poll = completionService.poll(3, TimeUnit.SECONDS);
                    if (poll == null) {
                        System.out.println("breal");
                        executor.shutdown();
                    } else {
                        System.out.println(poll.get());
                    }
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                    break;
                }
            }
        });

//        executor.shutdown();
        executor.awaitTermination(20, TimeUnit.SECONDS);
    }
}
