package noval.mandala.stream;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

public class OrdertingOperationTest {

    @Test
    void testSorted() {

        List.of("Eko", "Edo", "Kurniawan", "Khannedy", "Budi", "Joko").stream()
                .sorted()
                .forEach(System.out::println);
    }

    @Test
    void testSortedWithComparator() {

        Comparator<String> reverseComparator = Comparator.reverseOrder();

        List.of("Eko", "Edo", "Kurniawan", "Khannedy", "Budi", "Joko").stream()
                .sorted(reverseComparator)
                .forEach(System.out::println);
    }
}

