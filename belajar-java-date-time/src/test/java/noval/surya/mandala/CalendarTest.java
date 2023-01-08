package noval.surya.mandala;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.spi.CalendarDataProvider;

public class CalendarTest {

    @Test
    void create() {

        Calendar calendar = Calendar.getInstance();

        System.out.println(calendar);

        // konversi ke date agar bisa di baca dengan mudah
        Date date = Calendar.getInstance().getTime();
        System.out.println(date);
    }

    @Test
    void modifyCalendar() {

        Calendar calendar = Calendar.getInstance();

        calendar.set(calendar.YEAR, 1980);
        calendar.set(calendar.MONTH, Calendar.FEBRUARY);
        calendar.set(calendar.DAY_OF_WEEK, Calendar.MONDAY);
        calendar.set(calendar.HOUR_OF_DAY, 15);
        calendar.set(calendar.MINUTE, 50);
        calendar.set(calendar.SECOND, 30);
        calendar.set(calendar.MILLISECOND, 100);

        Date date = calendar.getTime();
        System.out.println(date.getTime());

    }

    @Test
    void getCalendar() {

        Calendar calendar = Calendar.getInstance();

        System.out.print(calendar.get(calendar.YEAR));
        System.out.print(calendar.get(calendar.MONTH));
        System.out.print(calendar.get(calendar.DAY_OF_MONTH));
        System.out.print(calendar.get(calendar.HOUR_OF_DAY));
        System.out.print(calendar.get(calendar.MINUTE));
        System.out.print(calendar.get(calendar.SECOND));
        System.out.print(calendar.get(calendar.MILLISECOND));

    }
}
