package noval.surya.mandala.reflection;

import noval.surya.mandala.reflection.data.Person;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class PackageTest {

    @Test
    void testGetPackage() {

        Class<Person> personClass = Person.class;
        Package aPackage = personClass.getPackage();

        System.out.println(aPackage.getName());
        System.out.println(Arrays.toString(aPackage.getAnnotations()));
    }
}
