package noval.surya.mandala.reflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayTest {

    @Test
    void testArrayClass() {

        Class<String[]> arrayClass = String[].class;
        Class<int[][]> intArrayClass = int[][].class;

        System.out.println(arrayClass.isArray());
        System.out.println(intArrayClass.isArray());

    }

    @Test
    void testArrayMember() {

        Class<String[]> arrayClass = String[].class;
        Class<int[][]> intArrayClass = int[][].class;

        System.out.println(Arrays.toString(arrayClass.getDeclaredFields()));
        System.out.println(Arrays.toString(arrayClass.getDeclaredMethods()));
        System.out.println(Arrays.toString(arrayClass.getDeclaredConstructors()));
        System.out.println(arrayClass.getComponentType());

    }

    @Test
    void testArrayManipulation() {

        Class<String[]> stringArrayClass = String[].class;

        String[] array = (String[]) Array.newInstance(stringArrayClass.getComponentType(), 10);

        System.out.println(Arrays.toString(array));

        Array.set(array, 0, "Noval");
        Array.set(array, 1, "Surya");
        Array.set(array, 2, "Mandala");

        System.out.println(Array.get(array, 0));
        System.out.println(Array.get(array, 1));
        System.out.println(Array.get(array, 2));
    }
}
