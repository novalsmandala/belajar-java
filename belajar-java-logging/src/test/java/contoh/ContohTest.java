package contoh;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ContohTest {

    private static Logger log = LoggerFactory.getLogger(ContohTest.class);

    @Test
    void testLevel() {

        log.trace("trace");
        log.debug("debug");
        log.info("info");
        log.warn("warn");
        log.error("error");

    }
}
