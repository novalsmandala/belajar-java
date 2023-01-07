package noval.surya.mandala.reflection;

import noval.surya.mandala.reflection.data.Nameable;
import noval.surya.mandala.reflection.data.Person;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class InterfaceTest {

    @Test
    void testClass() {

        Class<Nameable> nameableClass = Nameable.class;

        System.out.println(nameableClass.getName());
        System.out.println(nameableClass.getSuperclass());
        System.out.println(Arrays.toString(nameableClass.getInterfaces()));
        System.out.println(Arrays.toString(nameableClass.getDeclaredFields()));
        System.out.println(Arrays.toString(nameableClass.getDeclaredMethods()));
        System.out.println(Arrays.toString(nameableClass.getDeclaredConstructors()));
        System.out.println(nameableClass.isInterface());
    }

    @Test
    void testSuperInterfaces() {

        Class<Person> personClass = Person.class;

        System.out.println(Arrays.toString(personClass.getInterfaces()));
    }
}
