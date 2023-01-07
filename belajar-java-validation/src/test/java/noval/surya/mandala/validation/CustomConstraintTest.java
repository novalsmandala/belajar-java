package noval.surya.mandala.validation;

import noval.surya.mandala.validation.group.CreditCardPaymentGroup;
import noval.surya.mandala.validation.group.Customer;
import noval.surya.mandala.validation.group.VirtualAccountPaymentGroup;
import org.junit.jupiter.api.Test;

public class CustomConstraintTest extends AbstractValidatorTest{


    @Test
    void testCustomConstraintInvalid() {

        Payment payment = new Payment();
        payment.setOrderId("abcd");
        payment.setAmount(100_000L);
        payment.setVirtualAccount("123432");
        payment.setCustomer(new Customer("novalmandala@gmail.com", "noval"));

        validateWithGorup(payment, VirtualAccountPaymentGroup.class);
    }

    @Test
    void testCustomConstraintValid() {

        Payment payment = new Payment();
        payment.setOrderId("ABCD");
        payment.setAmount(100_000L);
        payment.setVirtualAccount("123432");
        payment.setCustomer(new Customer("novalmandala@gmail.com", "noval"));

        validateWithGorup(payment, VirtualAccountPaymentGroup.class);
    }
}
