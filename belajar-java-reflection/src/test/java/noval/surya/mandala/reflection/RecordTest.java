package noval.surya.mandala.reflection;

import noval.surya.mandala.reflection.data.Product;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;

public class RecordTest {

    @Test
    void testClassRecord() {

        Class<Product> productClass = Product.class;

        System.out.println(productClass.isRecord());
        System.out.println(Arrays.toString(productClass.getDeclaredFields()));
        System.out.println(Arrays.toString(productClass.getDeclaredMethods()));
        System.out.println(Arrays.toString(productClass.getDeclaredConstructors()));
        System.out.println(Arrays.toString(productClass.getRecordComponents()));
    }

    @Test
    void testGetRecordValue() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Class<Product> productClass = Product.class;
        Method id = productClass.getDeclaredMethod("id");

        Product product = new Product("1", "Xomai", 1_000_000L);
        System.out.println(id.invoke(product));
    }

    @Test
    void testGetRecordValueByComponent() throws InvocationTargetException, IllegalAccessException {

        Class<Product> productClass = Product.class;
        RecordComponent[] recordComponents = productClass.getRecordComponents();

        Product product = new Product("1", "Xomai", 1_000_000L);

        for (RecordComponent recordComponent : recordComponents) {
            Method accessor = recordComponent.getAccessor();
            System.out.println(accessor.getName());
            System.out.println(accessor.invoke(product));
        }
    }
}
