package noval.mandala.stream;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

public class SystemPipelineTest {

    @Test
    void testCreatedPipeline() {

        List<String> list = List.of("Noval", "Surya", "Mandala");

        Stream<String> stream = list.stream();

        Stream<String> stringUpper = stream.map(String::toUpperCase);

        Stream<String> streamMr = stringUpper.map(upper -> "Mr " + upper );

        streamMr.forEach(System.out::println);
    }

    @Test
    void testCreatedPipelineOk() {

        List<String> list = List.of("Noval", "Surya", "Mandala");

        list.stream()
                .map(name -> name.toUpperCase())
                .map(upper -> "Mr " + upper)
                .forEach(System.out::println);
    }
}
