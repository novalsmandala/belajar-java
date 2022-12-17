package noval.mandala.stream;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

public class CreateStreamBuilderTest {

    @Test
    void testCreateStreamBuilder() {

        Stream.Builder<String> stringBuilder = Stream.builder();
        stringBuilder.accept("Noval");
        stringBuilder.add("Surya").add("Mandala");

        Stream<String> stream = stringBuilder.build();
        stream.forEach(System.out::println);

    }

    @Test
    void testCreateStreamBuilderSimplify() {

        Stream<Object> stream = Stream.builder()
                .add("Noval").add("Surya").add("Mandala").build();
        stream.forEach(System.out::println);
    }
}
