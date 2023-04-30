package novalsmandala.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class JavaBeanTest {

    @Test
    void createJsonFromObject() throws JsonProcessingException {

        Person person = new Person();
        person.setId("1");
        person.setName("Noval");
        person.setHobbies(List.of("Coding", "Music", "Gaming"));

        Address address = new Address();
        address.setStreet("Pahlawan Semakam");
        address.setCity("Kendal");
        address.setCountry("Indonesia");

        person.setAddress(address);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(person);
        System.out.println(json);
    }

    @Test
    void readObjectFromJson() throws JsonProcessingException {
        String json = """
                {
                    "id":"1",
                    "name":"Noval",
                    "hobbies":["Coding","Music","Gaming"],
                    "address":{
                        "street":"Pahlawan Semakam",
                        "city":"Kendal",
                        "country":"Indonesia"
                        }
                }
                """;
        ObjectMapper objectMapper = new ObjectMapper();
        Person person = objectMapper.readValue(json, Person.class);

        Assertions.assertEquals("1", person.getId());
        Assertions.assertEquals("Noval", person.getName());
        Assertions.assertEquals(List.of("Coding", "Music", "Gaming"), person.getHobbies());
        Assertions.assertEquals("Pahlawan Semakam", person.getAddress().getStreet());
        Assertions.assertEquals("Kendal", person.getAddress().getCity());
        Assertions.assertEquals("Indonesia", person.getAddress().getCountry());
    }
}
