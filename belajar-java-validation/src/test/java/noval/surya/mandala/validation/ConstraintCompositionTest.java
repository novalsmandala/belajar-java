package noval.surya.mandala.validation;

import noval.surya.mandala.validation.group.CreditCardPaymentGroup;
import org.junit.jupiter.api.Test;

public class ConstraintCompositionTest extends AbstractValidatorTest {

    @Test
    void testComposition() {

        Payment payment = new Payment();
        payment.setOrderId("12341234lfsdklaafds");

        validateWithGorup(payment, CreditCardPaymentGroup.class);
    }
}
