package novalsmandala.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ObjectMapperTest {

    @Test
    void testCreateObjectMapper() {
        ObjectMapper pObjectMapper = new ObjectMapper();

        Assertions.assertNotNull(pObjectMapper);
    }
}
