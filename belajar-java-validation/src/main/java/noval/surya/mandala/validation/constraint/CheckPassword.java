package noval.surya.mandala.validation.constraint;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {CheckPasswordValidator.class})
@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPassword {

    String message() default "invalid invalid password and retype password must be same";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
