package novalmandala.resilience4j;

import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import io.github.resilience4j.ratelimiter.RateLimiterRegistry;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicLong;

public class RateLimiterRegistryTest {
    
    private Logger log = LoggerFactory.getLogger(this.getClass());
    
    private final AtomicLong counter = new AtomicLong(0L);

    @Test
    void testRateLimiterRegistry() {


        RateLimiterConfig config = RateLimiterConfig.custom()
                .limitForPeriod(100)
                .limitRefreshPeriod(Duration.ofMinutes(1))
                .timeoutDuration(Duration.ofSeconds(2))
                .build();

        RateLimiterRegistry registry = RateLimiterRegistry.ofDefaults();
        registry.addConfiguration("config", config);

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
