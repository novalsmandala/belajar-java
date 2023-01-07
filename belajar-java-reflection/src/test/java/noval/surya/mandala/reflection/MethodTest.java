package noval.surya.mandala.reflection;

import noval.surya.mandala.reflection.data.Person;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MethodTest {

    @Test
    void testGetMethod() {

        Class<Person> personClass = Person.class;

        Method[] methods = personClass.getDeclaredMethods();
        for (var method : methods) {
            System.out.println(method.getName());
            System.out.println(method.getReturnType());
            System.out.println(Arrays.toString(method.getGenericParameterTypes()));
            System.out.println(Arrays.toString(method.getGenericExceptionTypes()));
            System.out.println("================");
        }
    }

    @Test
    void testGetMethodValue() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Class<Person> personClass = Person.class;
        Method getFirstName = personClass.getDeclaredMethod("getFirstName");

        var person = new Person("Noval", "Mandala");
        String invoke = (String) getFirstName.invoke(person);
        System.out.println(invoke);
    }
}
