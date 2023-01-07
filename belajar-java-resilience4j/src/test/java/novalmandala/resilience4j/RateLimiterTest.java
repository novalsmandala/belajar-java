package novalmandala.resilience4j;

import io.github.resilience4j.ratelimiter.RateLimiter;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicLong;

public class RateLimiterTest {

    private Logger log = LoggerFactory.getLogger(RateLimiterTest.class);

    private final AtomicLong counter = new AtomicLong(0L);

    @Test
    void testRateLimiter() {

        RateLimiter rateLimiter = RateLimiter.ofDefaults("pzn");

        for (int i = 0; i < 10_000; i++) {
            Runnable runnable = RateLimiter.decorateRunnable(rateLimiter, () -> {
                long result = counter.incrementAndGet();
                log.info("Result = {}", result);
            });
            runnable.run();
        }
    }
}
