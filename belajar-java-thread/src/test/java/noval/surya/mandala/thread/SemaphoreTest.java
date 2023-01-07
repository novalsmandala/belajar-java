package noval.surya.mandala.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreTest {

    @Test
    void create() throws InterruptedException {

        final var semaphore = new Semaphore(1);
        final var executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 1000; i++) {

            executor.execute(() -> {
                try {
                    semaphore.acquire();
                    Thread.sleep(1000);
                    System.out.println("Finish ");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    semaphore.release();
                }

            });

        }

//        Thread.sleep(15_000);
        executor.awaitTermination(15, TimeUnit.SECONDS);
    }
}
