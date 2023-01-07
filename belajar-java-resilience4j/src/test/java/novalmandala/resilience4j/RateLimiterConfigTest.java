package novalmandala.resilience4j;

import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicLong;

public class RateLimiterConfigTest {

    private org.slf4j.Logger log = LoggerFactory.getLogger(RateLimiterTest.class);

    private final AtomicLong counter = new AtomicLong(0L);

    void callMe() {
        log.info("Try call me");
        throw new IllegalArgumentException("Ups error");
    }

    @Test
    void testRateLimiterConfig() {

        RateLimiterConfig config = RateLimiterConfig.custom()
                .limitForPeriod(500)
                .limitRefreshPeriod(Duration.ofSeconds(1))
                .timeoutDuration(Duration.ofSeconds(2))
                .build();

        RateLimiter rateLimiter = RateLimiter.of("pzn", config);

        for (int i = 0; i < 10_000; i++) {
            Runnable runnable = RateLimiter.decorateRunnable(rateLimiter, () -> {
                long result = counter.incrementAndGet();
                log.info("Result = {}", result);
            });
            runnable.run();
        }
    }
}
