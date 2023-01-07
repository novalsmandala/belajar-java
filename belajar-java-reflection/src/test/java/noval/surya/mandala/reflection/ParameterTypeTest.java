package noval.surya.mandala.reflection;

import noval.surya.mandala.reflection.data.Person;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

public class ParameterTypeTest {

    @Test
    void testFieldGeneric() throws NoSuchMethodException, NoSuchFieldException {

        Class<Person> personClass = Person.class;
        Field getHobbies = personClass.getDeclaredField("hobbies");
        getHobbies.setAccessible(true);

        Type type = getHobbies.getGenericType();
        System.out.println(type.getClass());

        if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                System.out.println(parameterizedType.getRawType());
                System.out.println(parameterizedType.getOwnerType());
                System.out.println(Arrays.toString(parameterizedType.getActualTypeArguments()));
        }
    }

    @Test
    void testGetMethodGeneric() throws NoSuchMethodException {

        Class<Person> personClass = Person.class;
        Method getHobbies = personClass.getDeclaredMethod("getHobbies");

        Type type = getHobbies.getGenericReturnType();
        System.out.println(type.getClass());

        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            System.out.println(parameterizedType.getRawType());
            System.out.println(parameterizedType.getOwnerType());
            System.out.println(Arrays.toString(parameterizedType.getActualTypeArguments()));
        }
    }

    @Test
    void testGetMethodParameterGeneric() throws NoSuchMethodException {

        Class<Person> personClass = Person.class;
        Method getHobbies = personClass.getDeclaredMethod("setHobbies", List.class);

        Type[] types = getHobbies.getGenericParameterTypes();
        for (var type : types) {
            System.out.println(type.getClass());

            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                System.out.println(parameterizedType.getRawType());
                System.out.println(parameterizedType.getOwnerType());
                System.out.println(Arrays.toString(parameterizedType.getActualTypeArguments()));
            }
        }

    }
}
