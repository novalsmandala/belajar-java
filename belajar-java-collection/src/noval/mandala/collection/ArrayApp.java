package noval.mandala.collection;

import java.util.Arrays;
import java.util.List;

public class ArrayApp {

    public static void main(String[] args) {

        List<String> names = List.of("Noval", "Surya", "Mandala");

        // ke object
        Object[] objects = names.toArray();
        // ke String
        String[] strings = names.toArray(new String[]{});

        System.out.println(Arrays.toString(objects));
        System.out.println(Arrays.toString(strings));
    }
}
