package novalmandala.resilience4j;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.core.functions.CheckedRunnable;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CircuitBreakerTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private void callMe() {
        logger.info("Call Me");
        throw new IllegalArgumentException("ups");
    }

    @Test
    void circuitBreaker() {

        CircuitBreaker circuitBreaker = CircuitBreaker.ofDefaults("pzn");

        for (int i = 0; i < 200; i++) {

            try {
                CheckedRunnable runnable = CircuitBreaker.decorateCheckedRunnable(circuitBreaker, () -> callMe());
                runnable.run();
            } catch (Throwable e){
                logger.error("error {}", e.getMessage());
            }
        }
    }

    @Test
    void circuitBreakerConfig() {

        CircuitBreakerConfig config = CircuitBreakerConfig.custom()
                .slidingWindowType(CircuitBreakerConfig.SlidingWindowType.COUNT_BASED)
                .failureRateThreshold(10f)
                .slidingWindowSize(10)
                .minimumNumberOfCalls(10)
                .build();

        CircuitBreaker circuitBreaker = CircuitBreaker.of("pzn", config);

        for (int i = 0; i < 200; i++) {

            try {
                CheckedRunnable runnable = CircuitBreaker.decorateCheckedRunnable(circuitBreaker, () -> callMe());
                runnable.run();
            } catch (Throwable e){
                logger.error("error {}", e.getMessage());
            }
        }
    }

    @Test
    void circuitBreakerRegistry() {

        CircuitBreakerConfig config = CircuitBreakerConfig.custom()
                .slidingWindowType(CircuitBreakerConfig.SlidingWindowType.COUNT_BASED)
                .failureRateThreshold(10f)
                .slidingWindowSize(10)
                .minimumNumberOfCalls(10)
                .build();

        CircuitBreakerRegistry registry = CircuitBreakerRegistry.ofDefaults();
        registry.addConfiguration("config", config);

        CircuitBreaker circuitBreaker = registry.circuitBreaker("pzn", "config");

        for (int i = 0; i < 200; i++) {

            try {
                CheckedRunnable runnable = CircuitBreaker.decorateCheckedRunnable(circuitBreaker, () -> callMe());
                runnable.run();
            } catch (Throwable e){
                logger.error("error {}", e.getMessage());
            }
        }
    }
}