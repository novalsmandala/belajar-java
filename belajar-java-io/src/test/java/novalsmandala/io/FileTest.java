package novalsmandala.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

public class FileTest {

    @Test
    void testCreateFile() {
        File file = new File("file.txt");

        Assertions.assertEquals("file.txt", file.getName());
        Assertions.assertFalse(file.exists());
    }
}
