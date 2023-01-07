package noval.surya.mandala.reflection;

import noval.surya.mandala.reflection.data.Person;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ClassTest {

    @Test
    void testClass() throws ClassNotFoundException {

        var personClass1 = Person.class;

        Class<?> personClass2 = Class.forName("noval.surya.mandala.reflection.data.Person");

        Person person = new Person();
        Class<? extends Person> personClass3 = person.getClass();
    }

    @Test
    void testClassMethod() {

        Class<Person> personClass = Person.class;

        System.out.println(personClass.getSuperclass());
        System.out.println(Arrays.toString(personClass.getInterfaces()));
        System.out.println(Arrays.toString(personClass.getConstructors()));
        System.out.println(Arrays.toString(personClass.getMethods()));
        System.out.println(Arrays.toString(personClass.getFields()));
        System.out.println(personClass.getModifiers());
        System.out.println(personClass.getPackage());
        System.out.println(personClass.getName());
    }
}
