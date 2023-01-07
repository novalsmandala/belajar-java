package noval.surya.mandala.validation;

import noval.surya.mandala.validation.group.CreditCardPaymentGroup;
import noval.surya.mandala.validation.group.VirtualAccountPaymentGroup;
import org.junit.jupiter.api.Test;

public class GroupTest extends AbstractValidatorTest{

    @Test
    void testCreditCardGroup() {

        Payment payment = new Payment();
        payment.setAmount(100_000L);
        payment.setOrderId("0001");
        payment.setCreditCard("123");

        validateWithGorup(payment, CreditCardPaymentGroup.class);

    }

    @Test
    void testVirtualAccount() {

        Payment payment = new Payment();
        payment.setAmount(100_000L);
        payment.setOrderId("0001");
        payment.setCreditCard("123");
        payment.setCreditCard("");

        validateWithGorup(payment, VirtualAccountPaymentGroup.class);

    }
}
