package noval.surya.mandala.validation;

import noval.surya.mandala.validation.group.VirtualAccountPaymentGroup;
import org.junit.jupiter.api.Test;

public class MessageInterpolationTest extends AbstractValidatorTest {

    @Test
    void testMessage() {

        Payment payment = new Payment();
        payment.setOrderId("12345678910");
        payment.setVirtualAccount("123");
        payment.setAmount(10L);

        validateWithGorup(payment, VirtualAccountPaymentGroup.class);
    }
}
