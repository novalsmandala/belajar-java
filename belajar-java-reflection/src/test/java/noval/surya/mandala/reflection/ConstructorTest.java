package noval.surya.mandala.reflection;

import noval.surya.mandala.reflection.data.Person;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ConstructorTest {

    @Test
    void testGetConstructor() {

        Class<Person> personClass = Person.class;

        Constructor<?>[] declaredConstructors = personClass.getDeclaredConstructors();
        for (Constructor<?> constructor : declaredConstructors) {
            System.out.println(constructor.getName());
            System.out.println(Arrays.toString(constructor.getParameterTypes()));
            System.out.println("====================");
        }
    }

    @Test
    void testCreateObjectUsingConstructor() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<Person> personClass = Person.class;
        Constructor<Person> constructor = personClass.getConstructor();
        Constructor<Person> constructorParameters =
                personClass.getConstructor(String.class, String.class);

        Person person1 = constructor.newInstance();
        Person person2 = constructorParameters.newInstance("Noval", "Mandala");

        System.out.println(person1);
        System.out.println(person2);

    }


}
