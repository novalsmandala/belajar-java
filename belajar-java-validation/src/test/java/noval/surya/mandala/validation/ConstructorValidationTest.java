package noval.surya.mandala.validation;

import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.util.Set;

public class ConstructorValidationTest extends AbstractValidatorTest {

    @Test
    void testValidationConstructorParameter() throws NoSuchMethodException {

        Person person = new Person();

        String firstName = "";
        String lastName = "";
        Address address = new Address();

        Constructor constructor = person.getClass().getConstructor(String.class, String.class, Address.class);

        Set<ConstraintViolation<Object>> violations = executableValidator
                .validateConstructorParameters(constructor, new Object[] {
                    firstName, lastName, address
        });

        for (ConstraintViolation<Object> violation : violations) {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
            System.out.println("========================");
        }
    }

    @Test
    void testValidationConstructorReturnValue() throws NoSuchMethodException {

        String firstName = "";
        String lastName = "";
        Address address = new Address();

        Person person = new Person(firstName, lastName, address);

        Constructor constructor = person.getClass().getConstructor(String.class, String.class, Address.class);

        Set<ConstraintViolation<Object>> violations = executableValidator
                .validateConstructorReturnValue(constructor, person);

        for (ConstraintViolation<Object> violation : violations) {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
            System.out.println("========================");
        }
    }
}
