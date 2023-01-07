package noval.surya.mandala.thread;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.concurrent.*;

public class BlockingQueueTest {

    @Test
    void arrayBlockingQueue() throws InterruptedException {

        final var queue = new ArrayBlockingQueue<>(5);
        final var executor = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 10; i++) {

            executor.execute(() -> {
                try {
                    queue.put("Data");
                    System.out.println("Finish Put Data");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

        }

        executor.execute(() -> {
            while (true) {
                try {
                    Thread.sleep(2000);
                    var value = queue.take();
                    System.out.println("Receive data : " + value);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executor.awaitTermination(30, TimeUnit.SECONDS);
    }

    @Test
    void LinkedBlockingQueue() throws InterruptedException {

        final var queue = new LinkedBlockingQueue<>();
        final var executor = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 10; i++) {

            executor.execute(() -> {
                try {
                    queue.put("Data");
                    System.out.println("Finish Put Data");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

        }

        executor.execute(() -> {
            while (true) {
                try {
                    Thread.sleep(2000);
                    var value = queue.take();
                    System.out.println("Receive data : " + value);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executor.awaitTermination(30, TimeUnit.SECONDS);
    }

    @Test
    void priorityBlockingQueue() throws InterruptedException {

        final var queue = new PriorityBlockingQueue<Integer>(10, Comparator.reverseOrder());
        final var executor = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 10; i++) {
            final var index = i;
            executor.execute(() -> {
                queue.put(index);
                System.out.println("Finish Put Data " + index);
            });

        }

        executor.execute(() -> {
            while (true) {
                try {
                    Thread.sleep(2000);
                    var value = queue.take();
                    System.out.println("Receive data : " + value);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executor.awaitTermination(30, TimeUnit.SECONDS);
    }

    @Test
    void delayedQueue() throws InterruptedException {

        final var queue = new DelayQueue<ScheduledFuture>();
        final var executor = Executors.newFixedThreadPool(20);
        final var executorScheduled = Executors.newScheduledThreadPool(10);

        for (int i = 1; i <= 10; i++) {
            final var index = i;
            queue.put(executorScheduled.schedule(() -> "Data " + index, i, TimeUnit.SECONDS));

        }

        executor.execute(() -> {
            while (true) {
                try {
                    Thread.sleep(2000);
                    var value = queue.take();
                    System.out.println("Receive data : " + value.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                }
            }

        });

        executor.awaitTermination(30, TimeUnit.SECONDS);
    }

    @Test
    void synchronousQueue() throws InterruptedException {

        final var queue = new SynchronousQueue<Integer>();
        final var executor = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 10; i++) {
            final var index = i;
            executor.execute(() -> {
                try {
                    queue.put(index);
                    System.out.println("Finish Put Data : " + index);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

        }

        executor.execute(() -> {
            while (true) {
                try {
                    Thread.sleep(2000);
                    var value = queue.take();
                    System.out.println("Receive data : " + value);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executor.awaitTermination(30, TimeUnit.SECONDS);
    }

    @Test
    void blockingDeque() throws InterruptedException {

        final var queue = new LinkedBlockingDeque<String>();
        final var executor = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 10; i++) {
            final var index = i;
                try {
                    queue.putLast("Data-" + index);
                    System.out.println("Finish Put Data : " + index);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
        }

        executor.execute(() -> {
            while (true) {
                try {
                    Thread.sleep(2000);
                    var value = queue.takeLast();
                    System.out.println("Receive data : " + value);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executor.awaitTermination(30, TimeUnit.SECONDS);
    }

    @Test
    void transferQueue() throws InterruptedException {

        final var queue = new LinkedTransferQueue<String>();
        final var executor = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 10; i++) {
            final var index = i;
            executor.execute(() -> {
                try {
                    queue.transfer("Data-" + index);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Finish Put Data : " + index);
            });

        }

        executor.execute(() -> {
            while (true) {
                try {
                    Thread.sleep(2000);
                    var value = queue.take();
                    System.out.println("Receive data : " + value);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executor.awaitTermination(30, TimeUnit.SECONDS);
    }
}
