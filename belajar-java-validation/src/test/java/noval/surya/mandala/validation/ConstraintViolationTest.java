package noval.surya.mandala.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class ConstraintViolationTest {

    private ValidatorFactory validatorFactory;

    private Validator validator;

    @BeforeEach
    void setUp() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @AfterEach
    void tearDown() {
        validatorFactory.close();
    }

    @Test
    void testValidationFailed() {

        Person person = new Person();

        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        Assertions.assertEquals(2, violations.size());

        for (ConstraintViolation<Person> violation : violations) {
            System.out.println("Message : " + violation.getMessage());
            System.out.println("Bean : " + violation.getLeafBean());
            System.out.println("Constraint : " + violation.getConstraintDescriptor().getAnnotation());
            System.out.println("Invalid Value : " + violation.getInvalidValue());
            violation.getPropertyPath().forEach(node -> System.out.println(node.getName()));
            System.out.println("========================================");
        }
    }

    @Test
    void testValidationFailedSize() {

        Person person = new Person();
        person.setFirstName("kllllklklklklklklklklklklklkklklklk");
        person.setLastName("kllllklklklklklklklklklklklkklklklk");

        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        Assertions.assertEquals(2, violations.size());

        for (ConstraintViolation<Person> violation : violations) {
            System.out.println("Message : " + violation.getMessage());
            System.out.println("Bean : " + violation.getLeafBean());
            System.out.println("Constraint : " + violation.getConstraintDescriptor().getAnnotation());
            System.out.println("Invalid Value : " + violation.getInvalidValue());
            violation.getPropertyPath().forEach(node -> System.out.println(node.getName()));
            System.out.println("========================================");
        }
    }

    @Test
    void testValidationSuccess() {

        Person person = new Person();
        person.setFirstName("Noval");
        person.setLastName("Mandala");

        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        Assertions.assertEquals(0, violations.size());

        for (ConstraintViolation<Person> violation : violations) {
            System.out.println("Message : " + violation.getMessage());
            System.out.println("Bean : " + violation.getLeafBean());
            System.out.println("Constraint : " + violation.getConstraintDescriptor().getAnnotation());
            System.out.println("Invalid Value : " + violation.getInvalidValue());
            violation.getPropertyPath().forEach(node -> System.out.println(node.getName()));
            System.out.println("========================================");
        }
    }
}
