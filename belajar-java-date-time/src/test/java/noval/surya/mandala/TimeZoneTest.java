package noval.surya.mandala;

import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.util.*;

public class TimeZoneTest {

    @Test
    void create() {

        TimeZone timeZone = TimeZone.getDefault();

        // coba menggunakan locale
        Locale locale = new Locale("id", "ID");

        System.out.println(timeZone.getDisplayName());
        System.out.println(timeZone.getDisplayName(locale));

        TimeZone timeZoneGMT = TimeZone.getTimeZone("GMT");
        System.out.println(timeZoneGMT.getDisplayName());

        String[] availableIDs = TimeZone.getAvailableIDs();
//        System.out.println(Arrays.asList(availableIDs));
        for (String availableID : availableIDs) {
            System.out.println(availableID);
        }

    }

    @Test
    void date() {

        Date date = new Date();
        System.out.println(date.toString());
        System.out.println(date.toGMTString());
    }

    @Test
    void calendar() {

        Calendar calendarJakarta = Calendar.getInstance(TimeZone.getTimeZone("Asia/Jakarta"));
        Calendar calendarGMT = Calendar.getInstance(TimeZone.getTimeZone("GMT"));

        System.out.println(calendarJakarta.get(Calendar.HOUR_OF_DAY));
        System.out.println(calendarGMT.get(Calendar.HOUR_OF_DAY));

        calendarJakarta.setTimeZone(TimeZone.getTimeZone("GTM"));
        System.out.println(calendarJakarta.get(Calendar.HOUR_OF_DAY));
    }
}
