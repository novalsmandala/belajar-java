package noval.surya.mandala.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class NestedValidationTest {

    private ValidatorFactory validatorFactory;

    private Validator validator;

    @BeforeEach
    void setUp() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @Test
    void testNestedFailed() {

        Person person = new Person();
        person.setFirstName("Noval");
        person.setLastName("Mandala");

        Address address = new Address();

        person.setAddress(address);

        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        Assertions.assertEquals(3, violations.size());

        for (ConstraintViolation<Person> violation : violations) {
            System.out.println(violation.getMessage());
            System.out.println(violation.getPropertyPath());
            System.out.println("============================");
        }

    }

    @Test
    void testNestedSuccess() {

        Person person = new Person();
        person.setFirstName("Noval");
        person.setLastName("Mandala");

        Address address = new Address();
        address.setCity("Serang");
        address.setCountry("Serang");
        address.setStreet("Serang");

        person.setAddress(address);

        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        Assertions.assertEquals(0, violations.size());

        for (ConstraintViolation<Person> violation : violations) {
            System.out.println(violation.getMessage());
            System.out.println(violation.getPropertyPath());
            System.out.println("============================");
        }

    }
}
