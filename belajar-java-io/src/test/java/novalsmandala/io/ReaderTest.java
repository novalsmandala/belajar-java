package novalsmandala.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReaderTest {

    @Test
    void testReader() {
        Path path = Path.of("output.txt");
        try (Reader reader = Files.newBufferedReader(path)) {
            StringBuilder stringBuilder = new StringBuilder();
            int data, counter = 0;
            while ((data = reader.read()) != -1) {
                stringBuilder.append((char) data);
                counter++;
            }
            System.out.println(stringBuilder);
            System.out.println(counter);
        } catch (IOException e) {
            Assertions.fail(e);
        }
    }

    @Test
    void testReadChars() {
        Path path = Path.of("output.txt");
        try (Reader reader = Files.newBufferedReader(path)) {
            StringBuilder stringBuilder = new StringBuilder();
            char[] chars = new char[1024];
            int length, counter = 0;
            while ((length = reader.read(chars)) != -1) {
                stringBuilder.append(chars, 0, length);
                counter++;
            }
            System.out.println(stringBuilder);
            System.out.println(counter);
        } catch (IOException e) {
            Assertions.fail(e);
        }
    }
}
