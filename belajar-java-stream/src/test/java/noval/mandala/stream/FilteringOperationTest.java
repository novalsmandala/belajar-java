package noval.mandala.stream;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Predicate;

public class FilteringOperationTest {

    @Test
    void testFilter() {

        List<String> names = List.of("Noval", "Surya", "Surya", "Mandala", "Hebat", "Hebat");

        names.stream()
                .filter(name -> name.length() > 5)
                .forEach(System.out::println);

        List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).stream()
                        .filter(number -> number % 2 == 0)
                                .forEach(System.out::println);

    }

    @Test
    void testDistinct() {

        List<String> names = List.of("Noval", "Surya", "Surya", "Mandala", "Hebat", "Hebat");

        names.stream().distinct().forEach(System.out::println);
    }
}
