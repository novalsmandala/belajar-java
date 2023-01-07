package noval.surya.mandala.validation;

import noval.surya.mandala.validation.group.PaymentGroup;
import org.junit.jupiter.api.Test;

public class GroupSequenceTest extends AbstractValidatorTest{

    @Test
    void testGroupSequence() {

        Payment payment = new Payment();
        payment.setOrderId("001");
        payment.setAmount(100_000L);
        payment.setCreditCard("4111111111111111");

        validateWithGorup(payment, PaymentGroup.class);
    }
}
