package noval.surya.mandala.reflection;

import noval.surya.mandala.reflection.data.Person;
import org.junit.jupiter.api.Test;

public class SuperClassTest
{
    @Test
    void testSuperClass() {

        Class<Person> personClass = Person.class;

        Class<? super Person> superclass = personClass.getSuperclass();
        System.out.println(superclass);

        Class<? super Person> nullClass = superclass.getSuperclass();
        System.out.println(nullClass);
    }
}
