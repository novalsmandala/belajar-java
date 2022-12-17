package noval.mandala.stream;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class LazyEvaluationTest {

    @Test
    void testIntermediateOperation() {

        List<String> names = List.of("Noval", "Surya", "Mandala");

        names.stream()
                .map(name -> {
                    System.out.println(
                            "Change " + name + " to UPPERCASE"
                    );
                    return name.toUpperCase();
                })
                .map(upper -> {
                    System.out.println(
                            "Change " + upper + " to Mr"
                    );
                    return "Mr " + upper;
                })
                .forEach(System.out::println);
    }
}
