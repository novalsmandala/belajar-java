package novalsmandala.io;

import org.junit.jupiter.api.Test;

import java.io.StringWriter;

public class MemoryStreamTest {

    @Test
    void testMemoryStream() {
        StringWriter writer = new StringWriter();
        for (int i = 0; i < 10; i++) {
            writer.write("Hello World\n");
        }

        String content = writer.getBuffer().toString();
        System.out.println(content);
    }
}
