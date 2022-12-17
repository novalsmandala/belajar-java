package noval.mandala.stream;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

public class AgregateOperationTest {

    @Test
    void testMax() {
        List.of("Noval", "Surya", "Mandala").stream()
                .max(Comparator.naturalOrder())
                .ifPresent(System.out::println);
    }

    @Test
    void testCount() {

        long count = List.of("Noval", "Surya", "Mandala").stream()
                .count();

        System.out.println(count);
    }

    @Test
    void testReduceOperator() {

        /* sum
        * 0
        * 1. value = 0 + 1
        * 2. value = 1 + 2
        * 3. value = 3 + 3
        * 4. value = 6 + 4
        * 5. value = 10 + 5
        * dan return value = 5 */
        long sum = List.of(1, 2, 3, 4, 5).stream()
                .reduce(0, (value, item) -> value + item);
        System.out.println(sum);
    }


    @Test
    void testFacorial() {

        /* sum
         * 0
         * 1. value = 0 * 1
         * 2. value = 1 * 2
         * 3. value = 3 * 3
         * 4. value = 6 * 4
         * 5. value = 10 * 5
         * dan return value = 5 */
        long sum = List.of(1, 2, 3, 4, 5).stream()
                .reduce(1, (value, item) -> value * item);
        System.out.println(sum);
    }
}
