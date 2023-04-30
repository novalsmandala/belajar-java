package novalsmandala.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class ObjectStreamTest {

    @Test
    void testSavePerson() {
        Person person = new Person();
        person.setId("1");
        person.setName("Noval");
        Path path = Path.of("noval.person");

        try (OutputStream outputStream = Files.newOutputStream(path);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {
            objectOutputStream.writeObject(person);
            objectOutputStream.flush();
        } catch (IOException e) {
            Assertions.fail(e);
        }
    }

    @Test
    void testGetPerson() {
        Path path = Path.of("noval.person");
        try (InputStream inputStream = Files.newInputStream(path);
             ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
            Person person = (Person)objectInputStream.readObject();
            Assertions.assertEquals("1", person.getId());
            Assertions.assertEquals("Noval", person.getName());
        } catch (IOException | ClassNotFoundException e) {
            Assertions.fail(e);
        }
    }
}
