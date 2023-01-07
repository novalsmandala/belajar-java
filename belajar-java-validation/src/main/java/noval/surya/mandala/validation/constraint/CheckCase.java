package noval.surya.mandala.validation.constraint;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.groups.Default;
import noval.surya.mandala.validation.enums.CaseMode;
import noval.surya.mandala.validation.group.CreditCardPaymentGroup;
import noval.surya.mandala.validation.group.VirtualAccountPaymentGroup;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {CheckCaseValidator.class})
@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckCase {

    CaseMode mode();

    String message() default "invalid order id";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
