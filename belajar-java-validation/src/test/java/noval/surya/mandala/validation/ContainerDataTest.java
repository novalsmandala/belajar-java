package noval.surya.mandala.validation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ContainerDataTest extends AbstractValidatorTest {

    @Test
    void testContainerData() {

        Person person = new Person();
        person.setFirstName("noval");
        person.setLastName("mandala");
        person.setAddress(new Address());
        person.getAddress().setStreet("Serang");
        person.getAddress().setCity("Serang");
        person.getAddress().setCountry("Indonesia");

        person.setHobbies(new ArrayList<>());
        person.getHobbies().add("");
        person.getHobbies().add("   ");
        person.getHobbies().add("gaming");

        validate(person);

    }
}
