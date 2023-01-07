package noval.surya.mandala.thread;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.*;

public class CompletableFutureTest {

    private ExecutorService executorService = Executors.newFixedThreadPool(10);

    private Random random = new Random();

    public CompletableFuture<String> getValue(){
        CompletableFuture<String> future = new CompletableFuture<>();

        try {
            Thread.sleep(2000L);
            future.complete("Noval Surya Mandala");
        } catch (InterruptedException e) {
            future.completeExceptionally(e);
        }

        return future;
    }

    @Test
    void create() throws ExecutionException, InterruptedException {

        Future<String> future = getValue();
        System.out.println(future.get());

    }

    private void execute(CompletableFuture<String> future, String value) {

        executorService.execute(() -> {
            try {
                Thread.sleep(1000 + random.nextInt(5000));
                future.complete(value);
            } catch (InterruptedException e) {
                future.completeExceptionally(e);
            }
        });
    }

    public Future<String> getFastest() {
        CompletableFuture<String> future = new CompletableFuture<>();

        execute(future, "Thread 1");
        execute(future, "Thread 2");
        execute(future, "Thread 3");

        return future;
    }

    @Test
    void testFaster() throws ExecutionException, InterruptedException {
        System.out.println(getFastest().get());
    }

    @Test
    void testCompletionStage() throws ExecutionException, InterruptedException {

        CompletableFuture<String> future = getValue();

        CompletableFuture<String[]> completableFuture = future.thenApply(String::toUpperCase)
                .thenApply(value -> value.split(" "));

        for (var value : completableFuture.get()) {
            System.out.println(value);
        }
    }
}
