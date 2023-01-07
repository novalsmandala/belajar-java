package noval.surya.mandala.reflection;

import com.sun.security.jgss.GSSUtil;
import noval.surya.mandala.reflection.data.Person;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ParameterTest {

    @Test
    void testGetParameter() {

        Class<Person> personClass = Person.class;
        Method[] declaredMethods = personClass.getDeclaredMethods();
        for (var method : declaredMethods) {
            System.out.println(method.getName());
            Parameter[] parameters = method.getParameters();
            for (var parameter : parameters) {
                System.out.println("Parameter Name :" + parameter.getName().toString());
                System.out.println("Parameter Type :" + parameter.getType().toString());
            }
            System.out.println("====================");
        }
    }

    @Test
    void testInvokeMethodWithParameter() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Class<Person> personClass = Person.class;
        Method setFirstName = personClass.getDeclaredMethod("setFirstName", String.class);

        Person person = new Person("Surya", "Mandala");
        setFirstName.invoke(person, "Noval");

        System.out.println(person.getFirstName());
    }
}
