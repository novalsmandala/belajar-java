package novalsmandala.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriterTest {

    @Test
    void testWriter() {
        Path path = Path.of("writer.txt");
        try (Writer writer = Files.newBufferedWriter(path)) {
            for (int i = 0; i < 100; i++) {
                writer.write("Hello Wordl\n");
                writer.flush();
            }
        } catch (IOException e) {
            Assertions.fail(e);
        }

        Assertions.assertTrue(Files.exists(path));
    }
}
