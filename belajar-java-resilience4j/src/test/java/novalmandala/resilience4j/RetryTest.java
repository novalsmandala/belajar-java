package novalmandala.resilience4j;

import io.github.resilience4j.retry.Retry;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Supplier;

public class RetryTest {

    private static final Logger log = LoggerFactory.getLogger(RetryTest.class);

    void callMe() {
        log.info("Try call me");
        throw new IllegalArgumentException("Ups error");
    }

    @Test
    void createNewRetry() {

        Retry retry = Retry.ofDefaults("pzn");

        Runnable runnable = Retry.decorateRunnable(retry, () -> callMe());
        Assertions.assertThrows(IllegalArgumentException.class, () -> runnable.run());
    }

    String hello() {
        log.info("call say hello");
        throw new IllegalArgumentException("Ups error");
    }

    @Test
    void createRetrySupplier() {

        Retry retry = Retry.ofDefaults("PZN");
        Supplier<String> stringSupplier = Retry.decorateSupplier(retry, () -> hello());
        Assertions.assertThrows(IllegalArgumentException.class, () -> stringSupplier.get());
    }
}
