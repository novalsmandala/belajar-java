package noval.surya.mandala.validation;

import org.junit.jupiter.api.Test;

public class ClassLevelValidationTest extends AbstractValidatorTest {

    @Test
    void testClassLevel() {

        Register register = new Register();
        register.setUsername("noval");
        register.setPassword("rahasia");
        register.setRetypePassword("beda");

        validate(register);

    }
}
