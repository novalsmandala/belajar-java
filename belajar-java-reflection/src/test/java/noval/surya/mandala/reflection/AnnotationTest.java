package noval.surya.mandala.reflection;

import noval.surya.mandala.reflection.data.Person;
import noval.surya.mandala.reflection.validation.ValidateNoteBlank;
import org.junit.jupiter.api.Test;

public class AnnotationTest {

    @Test
    void testValidateUsingAnnotation() throws IllegalAccessException {

        Person person = new Person("Mandala", "");
        ValidateNoteBlank.validateNotBlank(person);
    }
}
