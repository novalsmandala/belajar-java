package noval.surya.mandala.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.MessageInterpolator;
import noval.surya.mandala.validation.group.CreditCardPaymentGroup;
import org.hibernate.validator.internal.engine.MessageInterpolatorContext;
import org.hibernate.validator.messageinterpolation.ExpressionLanguageFeatureLevel;
import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.Set;

public class MessageInternationalizationTest extends AbstractValidatorTest{

    @Test
    void testI18n() {

        Locale.setDefault(new Locale("id", "ID"));
        Payment payment = new Payment();
        payment.setOrderId("123124123577");
        payment.setAmount(10L);

        validateWithGorup(payment, CreditCardPaymentGroup.class);

    }

    @Test
    void testMessageInterpolator() {

        Payment payment = new Payment();
        payment.setOrderId("123124123577");
        payment.setAmount(10L);

        Locale locale = new Locale("in", "ID");

        Set<ConstraintViolation<Object>> violations = validator.validate(payment, CreditCardPaymentGroup.class);

        for (ConstraintViolation<Object> violation : violations) {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessageTemplate());

            MessageInterpolator.Context context = new MessageInterpolatorContext(
                    violation.getConstraintDescriptor(), violation.getInvalidValue(), violation.getRootBeanClass(),
                    violation.getPropertyPath() , violation.getConstraintDescriptor().getAttributes(),
                    violation.getConstraintDescriptor().getAttributes(),
                    ExpressionLanguageFeatureLevel.VARIABLES, true
            );

//            System.out.println(context);
            String message = messageInterpolator.interpolate(violation.getMessageTemplate(), context, locale);
//            System.out.println(message);

            System.out.println("========================");
        }
    }
}
