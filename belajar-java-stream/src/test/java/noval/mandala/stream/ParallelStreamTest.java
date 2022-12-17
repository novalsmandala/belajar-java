package noval.mandala.stream;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParallelStreamTest {

    @Test
    void testSequential() {

        List<Integer> data = new LinkedList();

        for (int i = 0; i < 1_000_000; i++) {
           data.add(i);
        }
//        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        data.stream()
                .forEach(number ->{
                    System.out.println(Thread.currentThread().getName()
                     + " : " + number);
                });
    }

    @Test
    void testParallel() {

        List<Integer> data = new LinkedList();

        for (int i = 0; i < 1_000_000; i++) {
            data.add(i);
        }

//        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
          data.stream()
                .parallel()
                .forEach(number ->{
                    System.out.println(Thread.currentThread().getName()
                            + " : " + number);
                });
    }
}
