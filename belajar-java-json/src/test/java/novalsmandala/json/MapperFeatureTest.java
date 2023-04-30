package novalsmandala.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MapperFeatureTest {

    @Test
    void mapperFeature() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper().
                configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        String json = """
                {"ID": 1, "Name": "Noval"}
                """;
        Person person = objectMapper.readValue(json, Person.class);
        Assertions.assertEquals("1", person.getId());
        Assertions.assertEquals("Noval", person.getName());
    }

    @Test
    void deserializationFeature() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String json = """
                {"id": "1", "name": "Noval", "age": 10, "hobbies":"Coding"}
                """;
        Person person = objectMapper.readValue(json, Person.class);
        Assertions.assertEquals("1", person.getId());
        Assertions.assertEquals("Noval", person.getName());
        Assertions.assertEquals(List.of("Coding"), person.getHobbies());
    }

    @Test
    void serializationFeature() throws JsonProcessingException {
        Person person = new Person();
        person.setId("1");
        person.setName("Noval");
        person.setHobbies(List.of("Coding", "Music", "Gaming"));

        Address address = new Address();
        address.setStreet("Pahlawan Semakam");
        address.setCity("Kendal");
        address.setCountry("Indonesia");

        person.setAddress(address);

        ObjectMapper objectMapper = new ObjectMapper()
                .configure(SerializationFeature.INDENT_OUTPUT, true);
        String json = objectMapper.writeValueAsString(person);
        System.out.println(json);
    }

    @Test
    void serializationInclusion() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);

        Person person = new Person();
        person.setId("1");
        person.setName("Noval");

        String json = objectMapper.writeValueAsString(person);
        System.out.println(json);
    }
}
