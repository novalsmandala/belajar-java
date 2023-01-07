package noval.surya.mandala.validation.constraint;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {CheckPasswordParameterValidator.class})
@Target({ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPasswordParameter {

    int passwordParam();

    int retypePasswordParam();

    String message() default "invalid invalid password and retype password must be same";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
