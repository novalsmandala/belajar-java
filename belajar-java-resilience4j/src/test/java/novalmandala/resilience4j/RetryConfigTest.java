package novalmandala.resilience4j;

import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.function.Supplier;

public class RetryConfigTest {

    private static Logger log = LoggerFactory.getLogger(RetryConfigTest.class);

    private String hello() {
        log.info("Call hello");
        throw new IllegalArgumentException("error");
    }

    @Test
    void retryConfig() {

        RetryConfig config = RetryConfig.custom()
                .maxAttempts(5)
                .waitDuration(Duration.ofSeconds(2))
                .ignoreExceptions(IllegalArgumentException.class)
                .build();

        Retry retry = Retry.of("pzn", config);

        Supplier<String> supplier = Retry.decorateSupplier(retry, () -> hello());

        supplier.get();

    }
}
