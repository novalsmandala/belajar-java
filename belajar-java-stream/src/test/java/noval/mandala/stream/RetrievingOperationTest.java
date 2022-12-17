package noval.mandala.stream;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class RetrievingOperationTest {

    @Test
    void testLimit() {

        List.of("Noval", "Surya", "Mandala").stream()
                .limit(2).forEach(System.out::println);
    }

    @Test
    void testSkip() {

        List.of("Noval", "Surya", "Mandala").stream()
                .skip(2).forEach(System.out::println);
    }

    @Test
    void testTakeWhile() {

        // menjalankan sampai data true terakhir jika ada yang false maka stream akan selesai
        // atau mengambil data sebagian yang true
        List.of("A", "Eko", "Edo", "Kurniawan", "Khannedy", "Budi", "Joko").stream()
                .takeWhile(name -> name.length() <= 2)
                .forEach(System.out::println);
    }

    @Test
    void testDropWhile() {

        // akan menghiraukan data yang ture
        List.of("Eko", "Edo", "Kurniawan", "Khannedy", "Budi", "Joko").stream()
                .dropWhile(name -> name.length() <= 4)
                .forEach(System.out::println);
    }

    @Test
    void testFindAny() {
        Optional<String> optional = List.of("Eko", "Edo", "Kurniawan", "Khannedy", "Budi", "Joko")
                .stream().findAny();

        optional.ifPresent(name -> System.out.println(name));
    }

    @Test
    void testFindFirst() {

        Optional<String> optional = List.of("Noval", "Eko", "Edo", "Kurniawan", "Khannedy", "Budi", "Joko")
                .stream().findFirst();

        optional.ifPresent(name -> System.out.println(name));
    }


}
