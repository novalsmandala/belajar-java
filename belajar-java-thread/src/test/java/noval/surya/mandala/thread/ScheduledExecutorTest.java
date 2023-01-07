package noval.surya.mandala.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorTest {

    @Test
    void delayedJob() throws InterruptedException {

        var executor = Executors.newScheduledThreadPool(10);

        ScheduledFuture<?> future = executor.schedule(() -> System.out.println("Hello scheduld"), 5, TimeUnit.SECONDS);

        System.out.println(future.getDelay(TimeUnit.MILLISECONDS));

//        executor.awaitTermination(1, TimeUnit.DAYS);
        Thread.sleep(10000L);
    }

    @Test
    void periodicJob() throws InterruptedException {

        var executor = Executors.newScheduledThreadPool(10);

        ScheduledFuture<?> future = executor.scheduleAtFixedRate(() -> System.out.println("Hello scheduld"), 5, 2, TimeUnit.SECONDS);

        System.out.println(future.getDelay(TimeUnit.MILLISECONDS));

//        executor.awaitTermination(1, TimeUnit.DAYS);
        Thread.sleep(10000L);
    }

}
