package noval.surya.mandala.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Exchanger;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExchangerTest {

    @Test
    void test() throws InterruptedException {

        final var exchanger = new Exchanger<String>();
        final var executor = Executors.newFixedThreadPool(10);

        executor.execute(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("Thread 1 : Send : First");
                String first = exchanger.exchange("First");
                System.out.println("Thread 1 : Receive : " + first);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        executor.execute(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("Thread 2 : Send : Second");
                String second = exchanger.exchange("Second");
                System.out.println("Thread 2 : Receive : " + second);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        executor.awaitTermination(5, TimeUnit.SECONDS);
    }
}
