package novalsmandala.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
//import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class JsonObjectTest {

    @Test
    void createJson() throws JsonProcessingException {

        Map<String, Object> person = Map.of(
                "firstName", "Noval",
                "lastName", "Mandala",
                "age", 18,
                "married", false,
                "address", Map.of(
                        "street", "Pahlawan Semakam",
                        "regency", "Kendal",
                        "provincy", "Jawa Tengah",
                        "country", "Indonesia"
                )
        );
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(person);

        Path path = Path.of("person.json");
        try (OutputStream outputStream = Files.newOutputStream(path)) {
            objectMapper.writeValue(outputStream, person);
            outputStream.flush();
        } catch (IOException e) {
            Assertions.fail(e.getMessage());
        }

        System.out.println(json);
    }

    @Test
    void readJson() throws JsonProcessingException {
        String json = """
                {
                  "firstName": "Noval",
                  "lastName": "Mandala",
                  "married": false,
                  "age": 18,
                  "address": {
                    "regency": "Kendal",
                    "street": "Pahlawan Semakam",
                    "country": "Indonesia",
                    "provincy": "Jawa Tengah"
                  }
                }
                """;
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> person = objectMapper.readValue(json, new TypeReference<Map<String, Object>>(){});

        Assertions.assertEquals("Noval", person.get("firstName"));
        Assertions.assertEquals("Mandala", person.get("lastName"));
    }


}
