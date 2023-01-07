package noval.surya.mandala.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceTest {

    @Test
    void testExecutorService() throws InterruptedException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 100; i++) {

            executorService.execute(() -> {
                try {
                    Thread.sleep(500);
                    System.out.println("Runnable in thread : " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(15, TimeUnit.SECONDS);
    }
}
