package novalsmandala.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.xmlunit.builder.Input;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class CloseableTest {

    @Test
    void testCloseIO() throws IOException {
        Path path = Path.of("pom.xml");
        InputStream inputStream = null;

        try {
            inputStream = Files.newInputStream(path);
        } catch (IOException e) {
            Assertions.fail(e);
        } finally {
            if (inputStream == null) {
                inputStream.close();
            }
        }
    }

    @Test
    void testCloseIOWithResource() {
        Path path = Path.of("pom.xml");
        try (InputStream inputStream = Files.newInputStream(path);
             InputStream inputStream2 = Files.newInputStream(path);) {
            Assertions.assertTrue(true);
        } catch (IOException e) {
            Assertions.fail(e);
        }
    }
}
