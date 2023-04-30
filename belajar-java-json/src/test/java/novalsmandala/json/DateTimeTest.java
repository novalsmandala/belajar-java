package novalsmandala.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeTest {

    @Test
    void dateTimeInMilis() throws JsonProcessingException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");
        ObjectMapper objectMapper = new ObjectMapper()
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                .setDateFormat(format)
                .configure(SerializationFeature.INDENT_OUTPUT, true)
                .setSerializationInclusion(JsonInclude.Include.NON_NULL);

        Person person = new Person();
        person.setId("1");
        person.setName("Noval");
        person.setCreateAt(new Date());
        person.setUpdateAt(new Date());

        String json = objectMapper.writeValueAsString(person);
        System.out.println(json);
    }
}
