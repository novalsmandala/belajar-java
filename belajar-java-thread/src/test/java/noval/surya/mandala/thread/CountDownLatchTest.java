package noval.surya.mandala.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {

    @Test
    void create() throws InterruptedException {

        final var countDownLatch = new CountDownLatch(5);
        final var executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 5; i++) {
            executor.execute(() -> {
                try {
                    System.out.println("Start Task");
                    Thread.sleep(2000L);
                    System.out.println("FInish Task");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    countDownLatch.countDown();
                }
            });
        }

        executor.execute(() -> {
            try {
                countDownLatch.await();
                Thread.sleep(2000L);
                System.out.println("FInish All Task");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        executor.awaitTermination(15, TimeUnit.SECONDS );
    }
}
