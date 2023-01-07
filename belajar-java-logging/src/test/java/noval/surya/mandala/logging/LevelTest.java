package noval.surya.mandala.logging;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LevelTest {

    private static Logger log = LoggerFactory.getLogger(LevelTest.class);

    @Test
    void testLevel() {

        log.trace("trace");
        log.debug("debug");
        log.info("info");
        log.warn("warn");
        log.error("error");

    }

    @Test
    void testSize() {

        for (int i = 0; i < 100000; i++) {
            log.trace("trace" + i);
            log.debug("debug" + i);
            log.info("info" + i);
            log.warn("warn" + i);
            log.error("error" + i);
        }

    }
}
