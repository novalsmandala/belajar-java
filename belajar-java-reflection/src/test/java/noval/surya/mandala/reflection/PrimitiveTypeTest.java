package noval.surya.mandala.reflection;

import noval.surya.mandala.reflection.data.Person;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PrimitiveTypeTest {

    @Test
    void testClass() {

        Class<Integer> integerClass = int.class;
        Class<Long> longClass = long.class;
        Class<Boolean> booleanClass = boolean.class;

        System.out.println(integerClass.isPrimitive());
        System.out.println(longClass.isPrimitive());
        System.out.println(booleanClass.isPrimitive());
    }

    @Test
    void testGetField() throws NoSuchFieldException, IllegalAccessException {

        Class<Person> personClass = Person.class;
        Field age = personClass.getDeclaredField("age");
        System.out.println(age.getType().isPrimitive());

        age.setAccessible(true);

        Person person = new Person("Noval", "Mandala");
        person.setAge(18);

        System.out.println(age.getInt(person));

        age.setInt(person, 90);
        System.out.println(person.getAge());
    }

    @Test
    void testInvokeMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Class<Person> personClass = Person.class;
        Method setAge = personClass.getDeclaredMethod("setAge", int.class);

        Person person = new Person();
        setAge.invoke(person,18);

        System.out.println(person.getAge());
    }
}
