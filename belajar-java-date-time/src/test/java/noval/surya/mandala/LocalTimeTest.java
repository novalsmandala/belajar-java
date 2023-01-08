package noval.surya.mandala;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Locale;
import java.util.Set;

public class LocalTimeTest {

    @Test
    void localTimeTest() {

        LocalTime localTime1 = LocalTime.now();
        LocalTime localTime2 = LocalTime.of(10, 10, 10);
        LocalTime localTime3 = LocalTime.parse("10:30");

        System.out.println(localTime1);
        System.out.println(localTime2);
        System.out.println(localTime3);
    }

    @Test
    void change() {

        LocalTime localTime1 = LocalTime.now();
        LocalTime localTime2 = localTime1.withHour(10);
        LocalTime localTime3 = localTime1.withHour(12).withMinute(32).withSecond(22);

        System.out.println(localTime1);
        System.out.println(localTime2);
        System.out.println(localTime3);
    }

    @Test
    void modify() {

        LocalTime localTime = LocalTime.now();
        LocalTime localTime2 = localTime.plusHours(1);
        LocalTime localTime3 = localTime.plusHours(-1).plusMinutes(15).plusSeconds(30);

        System.out.println(localTime);
        System.out.println(localTime2);
        System.out.println(localTime3);
    }

    @Test
    void get() {

        LocalTime localTime = LocalTime.now();

        System.out.println(localTime.getHour());
        System.out.println(localTime.getMinute());
        System.out.println(localTime.getSecond());
        System.out.println(localTime.getNano());

    }
}
