package novalsmandala.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class OutputStreamTest {

    @Test
    void testOutputStream() {
        Path path = Path.of("output.txt");
        try (OutputStream outputStream = Files.newOutputStream(path)) {
            for (int i = 0; i < 100; i++) {
                outputStream.write("Hello World\n".getBytes());
                outputStream.flush();
            }
        } catch (IOException e) {
            Assertions.fail(e);
        }
    }

}
