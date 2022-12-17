package noval.mandala.stream;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

public class StreamOperationTest {

    @Test
    void testStreatOperation() {

        List<String> names = List.of("Noval", "Surya", "Mandala");
        Stream<String> stream = names.stream();
        Stream<String> stringUpper = stream.map(value -> value.toUpperCase());
        names.forEach(System.out::println);
        stringUpper.forEach(System.out::println);

    }
}
