package noval.surya.mandala.validation.constraint;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import noval.surya.mandala.validation.Register;

public class CheckPasswordValidator implements ConstraintValidator<CheckPassword, Register> {

    private String messageTemplate;

    @Override
    public void initialize(CheckPassword constraintAnnotation) {
        messageTemplate = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Register register, ConstraintValidatorContext context) {

        if (register.getPassword() == null || register.getRetypePassword() == null) {
            return true; // skip validation
        }

        boolean isValid = register.getPassword().equals(register.getRetypePassword());

        if (!isValid) {
            context.disableDefaultConstraintViolation();

            context.buildConstraintViolationWithTemplate(messageTemplate)
                    .addPropertyNode("password")
                    .addConstraintViolation();

            context.buildConstraintViolationWithTemplate(messageTemplate)
                    .addPropertyNode("retypePassword")
                    .addConstraintViolation();
        }

        return isValid;
    }
}
