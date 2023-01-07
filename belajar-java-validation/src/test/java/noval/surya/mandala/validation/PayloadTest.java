package noval.surya.mandala.validation;

import jakarta.validation.ConstraintViolation;
import noval.surya.mandala.validation.group.CreditCardPaymentGroup;
import noval.surya.mandala.validation.payload.EmailErrorPayload;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class PayloadTest extends AbstractValidatorTest{

    @Test
    void testPayload() {

        Payment payment = new Payment();

        payment.setOrderId("001");
        payment.setAmount(100_000L);
        payment.setCreditCard("wrond");

        Set<ConstraintViolation<Payment>> violations = validator.validate(payment, CreditCardPaymentGroup.class);

        for (ConstraintViolation<Payment> violation : violations) {
            violation.getConstraintDescriptor().getPayload().forEach(aClass -> {
                if (aClass == EmailErrorPayload.class) {
                    EmailErrorPayload emailErrorPayload = new EmailErrorPayload();
                    emailErrorPayload.sendEmail(violation);
                }
            });
        }
    }
}
