package noval.mandala.test;

import org.junit.jupiter.api.*;

// digunakan untuk membuat method run dalam satu objek
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(DescOrderer.class)
public class OrderedTest {

    // before all dan after all tanpa keyword static
    @BeforeAll
    void beforeAll() {
    }

    @AfterAll
    void afterAll() {
    }

    private int counter = 0;

    @Test
    @Order(1)
    void test3() {

        counter++;
        System.out.println(counter);
    }

    @Test
    @Order(2)
    void test2() {

        counter++;
        System.out.println(counter);
    }

    @Test
    @Order(3)
    void test1() {

        counter++;
        System.out.println(counter);
    }
}
