package noval.mandala.stream;

import org.junit.jupiter.api.Test;

import javax.xml.namespace.QName;
import java.util.List;

public class ForEachOperationTest {

    @Test
    void testPeek() {

        List.of("Noval", "Surya", "Mandala").stream()
                .map(name -> {
                    System.out.println("Before Change Name to Upper : " + name);
                    String upper = name.toUpperCase();
                    System.out.println("After Name to Upper" + upper);
                    return upper;
                }).forEach(name -> System.out.println("Final Name : " + name));
    }

    @Test
    void testPeekAfter() {

        List.of("Noval", "Surya", "Mandala").stream()
                .peek(name ->System.out.println("Before Change Name to Upper : " + name))
                .map(String::toUpperCase)
                .peek(upper -> System.out.println("Change Name to : " + upper))
                .forEach(finalName -> System.out.println("Final Name : " + finalName));
    }
}
