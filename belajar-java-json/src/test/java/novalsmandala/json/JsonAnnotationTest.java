package novalsmandala.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JsonAnnotationTest {

    @Test
    void annotation() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper()
                .configure(SerializationFeature.INDENT_OUTPUT, true)
                .setSerializationInclusion(JsonInclude.Include.NON_NULL);

        Person person = new Person();
        person.setId("1");
        person.setName("Noval");
        person.setFullName("novalsmandala");
        person.setPassword("rahasia");
        person.setCreateAt(new Date());
        person.setUpdateAt(new Date());

        String json = objectMapper.writeValueAsString(person);
        System.out.println(json);
    }
}
