package novalmandala.resilience4j;

import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.retry.RetryRegistry;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class RegistryTest {

    private Logger log = LoggerFactory.getLogger(RegistryTest.class);

    void callMe() {
        log.info("Try call me");
        throw new IllegalArgumentException("Ups error");
    }

    @Test
    void testRetryRegistery() {

            RetryRegistry registry = RetryRegistry.ofDefaults();

            Retry retry1 = registry.retry("pzn");
            Retry retry2 = registry.retry("pzn");

            Assertions.assertSame(retry1, retry2);
      }

    @Test
    void retryRegistryWithConfig() {

        RetryConfig config = RetryConfig.custom()
                .maxAttempts(5)
                .waitDuration(Duration.ofSeconds(2))
                .build();

        RetryRegistry registry = RetryRegistry.ofDefaults();
        registry.addConfiguration("config", config);

        Retry retry1 = registry.retry("pzn", config);
        Retry retry2 = registry.retry("pzn");

        Assertions.assertSame(retry1, retry2);

        Runnable runnable = Retry.decorateRunnable(retry1, () -> callMe());
        runnable.run();

    }
}
