package noval.mandala.test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.util.Properties;

public class ConditionTest {

    @Test
    void testSystemProperties() {
        Properties properties = System.getProperties();
        properties.forEach((o, o2) -> System.out.println(o + " : " + o2));
    }

    @Test
    @EnabledOnOs({OS.LINUX})
    public void testRunOnlyLinux(){
        System.out.println("you're run ini linux os");
    }

    @Test
    @DisabledOnOs({OS.LINUX})
    public void testDisableOnLinux(){
        System.out.println("you're run ini linux os");
    }

    @Test
    @EnabledOnJre({JRE.JAVA_19})
    void testEnableOnJava19() {
    }

    @Test
    @DisabledOnJre({JRE.JAVA_19})
    void testDisabledOnJava19() {
    }

    @Test
    @DisabledForJreRange(min = JRE.JAVA_14, max = JRE.JAVA_20)
    void testDisabledOnJava14To20() {
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_14, max = JRE.JAVA_20)
    void testEnabledOnJava14To20() {
    }

    @Test
    @EnabledIfSystemProperties({
            @EnabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    })
    void testEnabledOnJavaVendorOracle() {

    }

    @Test
    @DisabledIfSystemProperties({
            @DisabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    })
    void testDisabledOnJavaVendorOracle() {

    }

    @Test
    @EnabledIfEnvironmentVariables({
            @EnabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV")
    })
    void testEnabledOnProfileDev() {

    }

    @Test
    @DisabledIfEnvironmentVariables({
            @DisabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV", disabledReason = "Bukan DEV")
    })
    void testDisabledOnProfileDev() {

    }
}
