package noval.mandala.test.service;

import noval.mandala.test.data.Person;
import noval.mandala.test.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@Extensions({
        @ExtendWith(MockitoExtension.class)
})
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    private PersonService personService;

    @BeforeEach
    void setUp() {
        personService = new PersonService(personRepository);
    }

    @Test
    void testNotFound() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
           personService.get("Not Found") ;
        });
    }

    @Test
    void getGetPersonSuccess() {

        // menambah behavior ke moch object

        Mockito.when(personRepository.selectById("noval"))
                .thenReturn(new Person("noval", "Mandala"));

        var person = personService.get("noval");

        Assertions.assertNotNull(person);
    }


    @Test
    void testRegisterSuccess() {
        var person = personService.register("Noval");
        Assertions.assertNotNull(person.getName());
        Assertions.assertEquals("Noval", person.getName());
        Assertions.assertNotNull(person.getId());
        Mockito.verify(personRepository, Mockito.times(1)).insert(new Person(
                person.getId(), "Noval"
        ));
    }
}
