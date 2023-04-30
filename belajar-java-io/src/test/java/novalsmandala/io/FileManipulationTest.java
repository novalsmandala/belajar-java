package novalsmandala.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileManipulationTest {
    @Test
    void testCreate() throws IOException {
        Path path = Path.of("file.txt");
        Files.createFile(path);

        Assertions.assertTrue(Files.exists(path));
        Assertions.assertFalse(Files.isDirectory(path));
    }

    @Test
    void testDelete() throws IOException {
        Path path = Path.of("file.txt");

        Files.deleteIfExists(path);
        Assertions.assertFalse(Files.exists(path));
    }
}
