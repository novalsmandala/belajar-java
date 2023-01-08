package noval.surya.mandala;

import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

public class LegacyTest {

    @Test
    void fromLegacy() {

        Date date = new Date();
        System.out.println(date);
        Instant instant = date.toInstant();
        System.out.println(instant);

        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
        Instant instantCalendar = calendar.toInstant();
        System.out.println(instantCalendar);

        TimeZone timeZone = TimeZone.getDefault();
        System.out.println(timeZone);
        ZoneId instantTimeZone = timeZone.toZoneId();
        System.out.println(instantTimeZone);
    }

    @Test
    void toLegacy() {

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        Date date = Date.from(zonedDateTime.toInstant());

        Calendar calendar = GregorianCalendar.from(zonedDateTime);

        ZoneId zoneId = ZoneId.systemDefault();
        TimeZone timeZone = TimeZone.getTimeZone(zoneId);

        System.out.println(date);
        System.out.println(calendar.getCalendarType());
        System.out.println(timeZone.getDisplayName(new Locale(
                "id", "ID"
        )));

    }
}
