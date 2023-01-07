package novalmandala.resilience4j;

import io.github.resilience4j.retry.Retry;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

public class MetricTest {

    private String hello() {
        throw new IllegalArgumentException("Ups");
    }

    @Test
    void retry() {

        Retry retry = Retry.ofDefaults("pzn");

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
}
