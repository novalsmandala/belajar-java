package novalsmandala.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class InputStreamTest {

    @Test
    void read() {
        Path path = Path.of("pom.xml");
        try (InputStream stream = Files.newInputStream(path)) {
            StringBuilder stringBuilder = new StringBuilder();
            int data;
            int counter = 0;
            while ((data = stream.read()) != -1) {
                stringBuilder.append((char)data);
                counter++;
            }
            System.out.println(stringBuilder.toString());
            System.out.println("Banyak perulangan: " + counter);
        } catch (IOException e) {
            Assertions.fail(e);
        }
    }

    @Test
    void readWithBytes() {
        Path path = Path.of("pom.xml");
        try (InputStream stream = Files.newInputStream(path)) {
            StringBuilder stringBuilder = new StringBuilder();
            byte[] buffer = new byte[1024];
            int length;
            int counter = 0;
            while ((length = stream.read(buffer)) != -1) {
                stringBuilder.append(new String(buffer, 0, length));
                counter++;
            }
            System.out.println(stringBuilder);
            System.out.println("Banyak perulangan: " + counter);
        } catch (IOException e) {
            Assertions.fail(e);
        }
    }
}
