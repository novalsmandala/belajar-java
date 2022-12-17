package noval.mandala.test;

import org.junit.jupiter.api.Test;

public class LifeCycleTest {

    String name;

    @Test
    void testA() {
        name = "Noval";
    }

    @Test
    void testB() {
        System.out.println(name);
    }
}
