package noval.surya.mandala.validation.payload;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Payload;

public class EmailErrorPayload implements Payload {

    public void sendEmail(ConstraintViolation<?> violation) {
        System.out.println("send email because erorr : " + violation.getMessage());
    }

}
