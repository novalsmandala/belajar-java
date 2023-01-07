package noval.surya.mandala.thread;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FutureTest {

    @Test
    void testFuture() throws InterruptedException, ExecutionException {

        var executor = Executors.newSingleThreadExecutor();
        Callable<String> callable = () -> {

            Thread.sleep(10000);
            return "Hi";
        };

        Future<String> future = executor.submit(callable);

        while (!future.isDone()) {
            System.out.print("Waiting ");
            Thread.sleep(1000L);
        }

        System.out.println("Selesai Future");

        String value = future.get();
        System.out.println(value);

    }

    @Test
    void testFutureCancel() throws InterruptedException, ExecutionException {

        var executor = Executors.newSingleThreadExecutor();
        Callable<String> callable = () -> {
            Thread.sleep(10000);
            return "Hi";
        };

        Future<String> future = executor.submit(callable);

//        while (!future.isDone()) {
//            System.out.print("Waiting ");
//            Thread.sleep(1000L);
//        }

        System.out.println("Selesai Future");

        Thread.sleep(2000);
        future.cancel(true);

        String value = future.get();
        System.out.println(value);

    }

    @Test
    void invokeAll() throws InterruptedException, ExecutionException {

        var executor = Executors.newFixedThreadPool(10);

        List<Callable<String>> callables = IntStream.range(1, 11).mapToObj(value -> (Callable<String>) () ->{
            Thread.sleep(value * 500L);
            System.out.println("value ke " + value);
            return String.valueOf(value);
        }).collect(Collectors.toList());

        // menunggu dan mengembalikan semua
        List<Future<String>> futures = executor.invokeAll(callables);

        for (var future : futures) {
            System.out.println(future.get());
        }
    }

    @Test
    void invokeAny() throws InterruptedException, ExecutionException {

        var executor = Executors.newFixedThreadPool(10);

        List<Callable<String>> callables = IntStream.range(1, 11).mapToObj(value -> (Callable<String>) () ->{
            Thread.sleep(value * 500L);
            System.out.println("value ke " + value);
            return String.valueOf(value);
        }).collect(Collectors.toList());

        // paling cepat dia yang di kembalikan
        String result = executor.invokeAny(callables);

        System.out.println(result);
    }
}
