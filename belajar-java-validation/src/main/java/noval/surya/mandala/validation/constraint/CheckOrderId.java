package noval.surya.mandala.validation.constraint;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.groups.Default;
import noval.surya.mandala.validation.enums.CaseMode;
import noval.surya.mandala.validation.group.CreditCardPaymentGroup;
import noval.surya.mandala.validation.group.VirtualAccountPaymentGroup;

import java.lang.annotation.*;

@CheckCase(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class},
        mode = CaseMode.UPPER, message = "{order.id.upper}")
@NotBlank(groups = {Default.class, CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class}
        ,message = "{order.id.notblank}")
@Size(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class},min = 1, max = 10, message = "{order.id.size}")
@Documented
@Constraint(validatedBy = {})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@ReportAsSingleViolation // berfungsi agar error yang di beritahukan hanya satu
public @interface CheckOrderId {

    String message() default "invalid order id";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
