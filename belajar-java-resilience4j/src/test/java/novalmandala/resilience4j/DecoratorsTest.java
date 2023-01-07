package novalmandala.resilience4j;

import io.github.resilience4j.core.functions.CheckedRunnable;
import io.github.resilience4j.decorators.Decorators;
import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.function.Supplier;

public class DecoratorsTest {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    public void slow() throws InterruptedException {
        log.info("Slow");
        Thread.sleep(1000L);
        throw new IllegalArgumentException("ups");
    }

    public String sayHello() throws InterruptedException {
        log.info("say hello");
        Thread.sleep(1000L);
        throw new IllegalArgumentException("ups");
    }

    @Test
    void testDecorators() throws InterruptedException {
        RateLimiter rateLimiter = RateLimiter.of("pzn-ratelimiter", RateLimiterConfig.custom()
                .limitForPeriod(5)
                .limitRefreshPeriod(Duration.ofMinutes(1))
                .build());

        Retry retry = Retry.of("pzn-retry", RetryConfig.custom()
                .maxAttempts(10)
                .waitDuration(Duration.ofMillis(10))
                .build());
        Runnable runnable = Decorators.ofRunnable(() -> {
                    try {
                        slow();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                })
                .withRetry(retry)
                .withRateLimiter(rateLimiter).decorate();

        for (int i = 0; i < 100; i++) {
            new Thread(runnable).start();
        }
        Thread.sleep(10_000L);
    }

    @Test
    void fallback() throws InterruptedException {
        RateLimiter rateLimiter = RateLimiter.of("pzn-ratelimiter", RateLimiterConfig.custom()
                .limitForPeriod(5)
                .limitRefreshPeriod(Duration.ofMinutes(1))
                .build());

        Retry retry = Retry.of("pzn-retry", RetryConfig.custom()
                .maxAttempts(15)
                .waitDuration(Duration.ofMillis(10))
                .build());

        Supplier<String> supplier = Decorators.ofSupplier(() -> {
                    try {
                        return sayHello();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                })
                .withRetry(retry)
                .withRateLimiter(rateLimiter)
                .withFallback((throwable) -> "Hello guess")
                .decorate();

        System.out.println(supplier.get());
    }
}
