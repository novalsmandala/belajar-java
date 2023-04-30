package novalsmandala.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class PrintStreamTest {
    @Test
    void testConsole() {
        PrintStream printStream = System.out;
        printStream.println("Hello World");
        printStream.println("Hello World");
        printStream.println("Hello World");
    }

    @Test
    void testPrintStreamFile() {
        Path path = Path.of("print.txt");
        try (OutputStream outputStream = Files.newOutputStream(path);
            PrintStream printStream = new PrintStream(outputStream)) {
            printStream.println("Hello World");
            printStream.println("Hello World");
            printStream.print("Hello World");
        } catch (IOException e) {
            Assertions.fail(e);
        }
    }
}
