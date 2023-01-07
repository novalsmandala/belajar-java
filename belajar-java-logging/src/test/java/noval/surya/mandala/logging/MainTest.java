package noval.surya.mandala.logging;

import org.junit.jupiter.api.Test;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainTest {

    private static Logger log = LoggerFactory.getLogger(MainTest.class);

    @Test
    void testLog() {

        log.info("Hallo logger");
        System.out.println("Hallo logger");
        log.info("Selemat belajar java logging");
        System.out.println("Selemat belajar java logging");
    }
}
