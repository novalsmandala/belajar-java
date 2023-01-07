package novalmandala.resilience4j;

import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryRegistry;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Supplier;

public class EventPublisherTest {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    private String hello() {
        throw new IllegalArgumentException("Ups");
    }

    @Test
    void retry() {

        Retry retry = Retry.ofDefaults("pzn");
        retry.getEventPublisher().onRetry(event -> {
            log.info("try to retry");
        });
        retry.getEventPublisher().onError(event -> {
            log.info("erorr");
        });

        try {
            Supplier<String> supplier = Retry.decorateSupplier(retry, () -> hello());
            supplier.get();
        } catch (Exception e) {
            System.out.println(retry.getMetrics().getNumberOfFailedCallsWithRetryAttempt());
            System.out.println(retry.getMetrics().getNumberOfFailedCallsWithoutRetryAttempt());
            System.out.println(retry.getMetrics().getNumberOfSuccessfulCallsWithRetryAttempt());
            System.out.println(retry.getMetrics().getNumberOfSuccessfulCallsWithoutRetryAttempt());
        }
    }

    @Test
    void retryRegistry() {
        RetryRegistry registry = RetryRegistry.ofDefaults();

        registry.getEventPublisher().onEntryAdded(event -> {
            log.info("Add new retry {}", event.getAddedEntry().getName());
        });

        Retry retry1 = registry.retry("pzn");
        Retry retry2 = registry.retry("pzn");
        Retry retry3 = registry.retry("pzn2");
    }
}
