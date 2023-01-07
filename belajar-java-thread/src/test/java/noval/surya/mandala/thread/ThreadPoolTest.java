package noval.surya.mandala.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {

    @Test
    void create() {

        var minThread = 10;
        var maxThread = 100;
        var alive = 1;
        var aliveTime = TimeUnit.MINUTES;

        var queue =  new ArrayBlockingQueue<Runnable>(100);

        var threadPoolExecutor = new ThreadPoolExecutor(minThread, maxThread, alive, aliveTime, queue);
    }

    @Test
    void execute() throws InterruptedException {

        var minThread = 10;
        var maxThread = 100;
        var alive = 1;
        var aliveTime = TimeUnit.MINUTES;

        var queue =  new ArrayBlockingQueue<Runnable>(100);

        var threadPoolExecutor = new ThreadPoolExecutor(minThread, maxThread, alive, aliveTime, queue);

        threadPoolExecutor.execute(() -> {
            try {
                Thread.sleep(3000L);
                System.out.println("Runable from thread : " + Thread.currentThread().getName());

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread.sleep(6000L);
    }

    @Test
    void shutdown() throws InterruptedException {

        var minThread = 10;
        var maxThread = 100;
        var alive = 1;
        var aliveTime = TimeUnit.MINUTES;

        var queue =  new ArrayBlockingQueue<Runnable>(1000);

        var threadPoolExecutor = new ThreadPoolExecutor(minThread, maxThread, alive, aliveTime, queue);

        Runnable runnable = () -> {
            for (int i = 0; i < 1000; i++) {

                final var task = i;

                try {
                    Thread.sleep(1000L);
                    System.out.println("Task " + task + " from thread : " + Thread.currentThread().getName());

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        };

        threadPoolExecutor.execute(runnable);
        //        Thread.sleep(9000);
        //        threadPoolExecutor.shutdown();
//        threadPoolExecutor.shutdownNow();
        threadPoolExecutor.awaitTermination(30, TimeUnit.SECONDS);
    }

    @Test
    void rejected() throws InterruptedException {

        var minThread = 10;
        var maxThread = 100;
        var alive = 1;
        var aliveTime = TimeUnit.MINUTES;
        var queue =  new ArrayBlockingQueue<Runnable>(1);
        var rejectedHandler = new LogRejectedExecutionHandler();

        var threadPoolExecutor = new ThreadPoolExecutor(minThread, maxThread, alive, aliveTime, queue, rejectedHandler);


        for (int i = 0; i < 1000; i++) {
            final var task = i;
            Runnable runnable = () -> {

                try {
                    Thread.sleep(100L);
                    System.out.println("Task " + task + " from thread : " + Thread.currentThread().getName());

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            };
            threadPoolExecutor.execute(runnable);
        }


        //        Thread.sleep(9000);
        //        threadPoolExecutor.shutdown();
//        threadPoolExecutor.shutdownNow();
        threadPoolExecutor.awaitTermination(30, TimeUnit.SECONDS);
    }

    public static class LogRejectedExecutionHandler implements RejectedExecutionHandler{

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println("Task" + r + " is rejected");
        }
    }

}
