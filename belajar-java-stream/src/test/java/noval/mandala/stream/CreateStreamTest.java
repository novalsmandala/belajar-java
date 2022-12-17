package noval.mandala.stream;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class CreateStreamTest {

    @Test
    void testCreateEmptyOrSingleStream() {

        Stream<String> emptyStream = Stream.empty();
        emptyStream.forEach(s -> System.out.println(s));

        Stream<String> oneStream = Stream.of("Eko");
        oneStream.forEach(s -> System.out.println(s));

        String data = null;
        Stream<String> emptyOrNotStream = Stream.ofNullable(data);
        emptyOrNotStream.forEach(s -> System.out.println(s));
    }

    @Test
    void testCreateStramFromArray() {

        Stream<String> streamString = Stream.of("Noval", "Surya", "Mandala");
        streamString.forEach(System.out::println);

        Stream<Integer> streamiInteger = Stream.of(1, 2, 3, 4, 5, 6);
        streamiInteger.forEach(System.out::println);

        Stream<String> streamArrays = Arrays.stream(new String[]{"Noval", "Surya", "Mandala"});
        streamArrays.forEach(System.out::println);

    }

    @Test
    void testCreateStreamFromCollection() {

        Collection<String> collection = List.of("Noval", "Surya", "mandala");
        Stream<String> stringStream = collection.stream();
        stringStream.forEach(System.out::println);

        // hanya bisa dipakai sekali dan jika mau menggunakannya harus membuat streamnya lagi
        Stream<String> stringStream2 = collection.stream();
        stringStream2.forEach(System.out::println);
    }

    @Test
    void testCreateInfiniteStream() {

        Stream<String> stream = Stream.generate(() -> "Noval");
        //        stream.forEach(System.out::println); // unlimited looping

        Stream<Integer> iterate = Stream.iterate(1, value -> value + 1);
        //        iterate.forEach(System.out::println); // infinite loop

    }
}
