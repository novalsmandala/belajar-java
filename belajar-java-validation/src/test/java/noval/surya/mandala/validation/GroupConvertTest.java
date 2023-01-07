package noval.surya.mandala.validation;

import noval.surya.mandala.validation.group.CreditCardPaymentGroup;
import noval.surya.mandala.validation.group.Customer;
import noval.surya.mandala.validation.group.PaymentGroup;
import org.junit.jupiter.api.Test;

public class GroupConvertTest extends AbstractValidatorTest{

    @Test
    void testGroupConvert() {

        Payment payment = new Payment();
        payment.setOrderId("001");
        payment.setAmount(1_000_000L);
        payment.setCreditCard("411151234512345");
        payment.setCustomer(new Customer());

        validateWithGorup(payment, CreditCardPaymentGroup.class);
    }
}
