package noval.surya.mandala.validation;

import jakarta.validation.ConstraintViolation;
import noval.surya.mandala.validation.service.UserService;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Set;

public class CrossParameterValidationTest extends AbstractValidatorTest {

    @Test
    void testCrossParameter() throws NoSuchMethodException {

        String username = "novalmandala";
        String password = "rahasia";
        String retypePassword = "beda";

        UserService userService = new UserService();

        Method method = UserService.class.getMethod("register", String.class, String.class, String.class);

        Set<ConstraintViolation<UserService>> violations = executableValidator.validateParameters(userService, method, new Object[]{
                username, password, retypePassword
        });

        for (ConstraintViolation<UserService> violation : violations) {

            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
            System.out.println("===============================");

        }

        if (violations.size() == 0) System.out.println("Success");

    }
}
