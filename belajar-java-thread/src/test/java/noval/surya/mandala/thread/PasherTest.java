package noval.surya.mandala.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class PasherTest {

    @Test
    void countDown() throws InterruptedException {

        var paser = new Phaser();
        var executor = Executors.newFixedThreadPool(15);

        paser.bulkRegister(5);
        paser.bulkRegister(5);
        for (int i = 0; i < 10; i++) {

            executor.execute(() -> {
                try {
                    System.out.println("Start Task");
                    Thread.sleep(2000);
                    System.out.println("End Task");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    paser.arrive();
                }
            });


        }
        executor.execute(() -> {
            paser.awaitAdvance(0);
            System.out.println("All Task Done");
        });

        executor.awaitTermination(10, TimeUnit.SECONDS);

    }

    @Test
    void cyclicBarrier() throws InterruptedException {

        var paser = new Phaser();
        var executor = Executors.newFixedThreadPool(15);

        paser.bulkRegister(5);

        for (int i = 0; i < 5; i++) {

            executor.execute(() -> {
                paser.arriveAndAwaitAdvance();
                System.out.println("DONE");
            });
        }
        executor.awaitTermination(10, TimeUnit.SECONDS);
    }
}
