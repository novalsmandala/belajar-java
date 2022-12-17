package noval.mandala.stream;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

public class TranformationOperationTest {

    @Test
    void testMap() {
        List.of("Noval", "Surya", "Mandala").stream()
                .map(name -> name.toUpperCase())
                .map(upper -> upper.length())
                .forEach(length -> System.out.println(length));
    }

    @Test
    void testFlatMapOperation() {

        List.of("Noval", "Surya", "Mandala").stream()
                .map(name ->name.toUpperCase())
                .flatMap(upper -> Stream.of( upper, upper.length()))
                .flatMap(value -> Stream.of(value, value, value))
                .forEach(length -> System.out.println(length));
    }
}
