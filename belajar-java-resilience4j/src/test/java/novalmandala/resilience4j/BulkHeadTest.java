package novalmandala.resilience4j;

import io.github.resilience4j.bulkhead.*;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Supplier;

public class BulkHeadTest {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    private AtomicLong counter = new AtomicLong(0L);

    public void slow() throws InterruptedException {
        long value = counter.incrementAndGet();
        log.info("Slow - {}", value);
        Thread.sleep(1000L);
    }

    @Test
    void testSemaphore() throws InterruptedException {

        Bulkhead bulkhead = Bulkhead.ofDefaults("pzn");

        for (int i = 0; i < 1000; i++) {
            Runnable runnable = Bulkhead.decorateRunnable(bulkhead, () -> {
                try {
                    slow();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

            new Thread(runnable).start();
        }

        Thread.sleep(10_000L);
    }

    @Test
    void testThreadPool(){

        log.info(String.valueOf(Runtime.getRuntime().availableProcessors()));
        log.info(String.valueOf(Runtime.getRuntime().freeMemory()));
        log.info(String.valueOf(Runtime.getRuntime().maxMemory()));

        ThreadPoolBulkhead bulkhead = ThreadPoolBulkhead.ofDefaults("pzn");

        for (int i = 0; i < 1000; i++) {

            Supplier<CompletionStage<Void>> supplier = ThreadPoolBulkhead.decorateRunnable(bulkhead, () -> {
                try {
                    slow();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

            supplier.get();
        }
    }

    @Test
    void testSemaphoreConfig() throws InterruptedException {

        BulkheadConfig config = BulkheadConfig.custom()
                .maxConcurrentCalls(5)
                .maxWaitDuration(Duration.ofSeconds(5))
                .build();

        Bulkhead bulkhead = Bulkhead.of("pzn", config);

        for (int i = 0; i < 10; i++) {
            Runnable runnable = Bulkhead.decorateRunnable(bulkhead, () -> {
                try {
                    slow();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

            new Thread(runnable).start();
        }

        Thread.sleep(10_000L);
    }

    @Test
    void testThreadPoolConfig() throws InterruptedException {

        log.info(String.valueOf(Runtime.getRuntime().availableProcessors()));
        log.info(String.valueOf(Runtime.getRuntime().freeMemory()));
        log.info(String.valueOf(Runtime.getRuntime().maxMemory()));

        ThreadPoolBulkheadConfig config = ThreadPoolBulkheadConfig.custom()
                .maxThreadPoolSize(4)
                .coreThreadPoolSize(4)
                .queueCapacity(20)
                .build();

        ThreadPoolBulkhead bulkhead = ThreadPoolBulkhead.of("pzn", config);

        for (int i = 0; i < 20; i++) {

            Supplier<CompletionStage<Void>> supplier = ThreadPoolBulkhead.decorateRunnable(bulkhead, () -> {
                try {
                    slow();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

            supplier.get();
        }

        Thread.sleep(20_000);
    }

    @Test
    void testSemaphoreRegistry() throws InterruptedException {

        BulkheadConfig config = BulkheadConfig.custom()
                .maxConcurrentCalls(5)
                .maxWaitDuration(Duration.ofSeconds(5))
                .build();

        BulkheadRegistry bulkheadRegistry = BulkheadRegistry.ofDefaults();
        bulkheadRegistry.addConfiguration("config", config);
        Bulkhead bulkhead = bulkheadRegistry.bulkhead("pzn");

        for (int i = 0; i < 10; i++) {
            Runnable runnable = Bulkhead.decorateRunnable(bulkhead, () -> {
                try {
                    slow();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

            new Thread(runnable).start();
        }

        Thread.sleep(10_000L);
    }

    @Test
    void testThreadPoolRegistry() throws InterruptedException {

        log.info(String.valueOf(Runtime.getRuntime().availableProcessors()));
        log.info(String.valueOf(Runtime.getRuntime().freeMemory()));
        log.info(String.valueOf(Runtime.getRuntime().maxMemory()));

        ThreadPoolBulkheadConfig config = ThreadPoolBulkheadConfig.custom()
                .maxThreadPoolSize(4)
                .coreThreadPoolSize(4)
                .queueCapacity(20)
                .build();


        ThreadPoolBulkheadRegistry registry = ThreadPoolBulkheadRegistry.ofDefaults();
        registry.addConfiguration("config", config);
        ThreadPoolBulkhead bulkhead = registry.bulkhead("pzn");

        for (int i = 0; i < 20; i++) {

            Supplier<CompletionStage<Void>> supplier = ThreadPoolBulkhead.decorateRunnable(bulkhead, () -> {
                try {
                    slow();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

            supplier.get();
        }

        Thread.sleep(20_000);
    }
}
