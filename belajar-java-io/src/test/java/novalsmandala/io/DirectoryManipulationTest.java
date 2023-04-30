package novalsmandala.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DirectoryManipulationTest {

    @BeforeEach
    void setUp() throws IOException {
        Path path = Path.of("contoh");
        Files.deleteIfExists(path);
    }

    @Test
    void testCreateDirectory() throws IOException {
        Path path = Path.of("contoh");
        Files.createDirectory(path);

        Assertions.assertTrue(Files.exists(path));
        Assertions.assertTrue(Files.isDirectory(path));
    }

    @Test
    void testDeletDirectory() throws IOException {
        Path path = Path.of("contoh");
        Files.createFile(path);

        Files.delete(path);
        Assertions.assertFalse(Files.exists(path));
    }
}
