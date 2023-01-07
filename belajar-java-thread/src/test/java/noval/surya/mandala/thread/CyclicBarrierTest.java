package noval.surya.mandala.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;

public class CyclicBarrierTest {

    @Test
    void test() throws InterruptedException {

        final var cyclicBarrier = new CyclicBarrier(5);
        final var executer = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 5; i++) {
            executer.execute(() -> {
                try {
                    System.out.println("Waiting");
                    cyclicBarrier.await();
                    System.out.println("Done Waiting");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            });
            Thread.sleep(2000L);
        }
    }
}
