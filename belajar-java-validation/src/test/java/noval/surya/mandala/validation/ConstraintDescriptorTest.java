package noval.surya.mandala.validation;

import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import java.util.Set;

public class ConstraintDescriptorTest extends AbstractValidatorTest {

    @Test
    void testConstraintDescriptor() {

        Person person = new Person();

        Set<ConstraintViolation<Person>> violations = validator.validate(person);

        for (ConstraintViolation<Person> violation : violations) {

            System.out.println(violation.getConstraintDescriptor().getAnnotation());
            System.out.println(violation.getConstraintDescriptor().getAttributes());
            System.out.println("+======================+");
        }
    }
}
