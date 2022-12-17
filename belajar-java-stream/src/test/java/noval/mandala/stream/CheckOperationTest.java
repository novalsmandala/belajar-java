package noval.mandala.stream;

import org.junit.jupiter.api.Test;

import java.util.List;

public class CheckOperationTest {

    @Test
    void testAnyMatch() {

        // mengecek apakah di dalam stream ada yang true jika salah satu ada
        // yang true maka match akan bernilai true
        boolean match = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).stream()
                .anyMatch(number -> number > 20);
        System.out.println(match);
    }

    @Test
    void testAllMatch() {

        // allMatch berarti semua list dalam stream harus bernilai true akar bisa mengembalikan nilai true
        boolean match = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).stream()
                .anyMatch(number -> number < 20);
        System.out.println(match);

    }

    @Test
    void testNoneMatch() {

        // noneMatch berarti semua list dalam stream harus bernilai false akar bisa mengembalikan nilai true
        boolean match = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).stream()
                .noneMatch(number -> number > 20);
        System.out.println(match);

    }
}
