package noval.surya.mandala.reflection;

import noval.surya.mandala.reflection.data.Person;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

public class FieldTest {

    @Test
    void testGetFields() {

        Class<Person> personClass = Person.class;

        Field[] fields = personClass.getDeclaredFields();

        for (var field : fields) {
            System.out.println(field.getName() + " : " + field.getType().getName());
        }
    }

    @Test
    void testGetFieldValue() throws NoSuchFieldException, IllegalAccessException {

        Class<Person> personClass = Person.class;

        Field firstName = personClass.getDeclaredField("firstName");
        // mengubah aksesible menjadi true gar bisa di aksees
        firstName.setAccessible(true);

        var person1 = new Person("Noval", "Mandala");

        Object result = (String) firstName.get(person1);

        System.out.println(result);

        var person2 = new Person("Budi", "Nugraha");
        Object result2 = (String) firstName.get(person2);
        System.out.println(result2);

    }

    @Test
    void testSetFieldValue() throws NoSuchFieldException, IllegalAccessException {

        Class<Person> personClass = Person.class;

        Field firstName = personClass.getDeclaredField("firstName");
        // mengubah aksesible menjadi true gar bisa di aksees
        firstName.setAccessible(true);

        var person1 = new Person("Noval", "Mandala");

        firstName.set(person1, "Jack");
        System.out.println(person1.getFirstName());

        var person2 = new Person("Budi", "Nugraha");
        firstName.set(person2, "Tono");
        System.out.println(person2.getLastName());

    }
}
