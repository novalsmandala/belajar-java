package noval.surya.mandala;

import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.time.LocalDate;

public class LocalDateTest {

    @Test
    void create() {

        LocalDate localDate1 = LocalDate.now();
        LocalDate localDate2 = LocalDate.of(2004, 11, 28);
        LocalDate localDate3 = LocalDate.parse("2022-12-19");

        System.out.println(localDate1);
        System.out.println(localDate2);
        System.out.println(localDate3);

    }

    @Test
    void with() {

        LocalDate localDate1 = LocalDate.now();
        LocalDate localDate2 = localDate1.withYear(2000);
        LocalDate localDate3 = localDate1.withYear(2004).withMonth(11).withDayOfMonth(28);

        System.out.println(localDate1);
        System.out.println(localDate2);
        System.out.println(localDate3);
    }

    @Test
    void modify() {

        LocalDate localDate1 = LocalDate.now();
        LocalDate localDate2 = localDate1.plusYears(10);
        LocalDate localDate3 = localDate1.minusMonths(12);

        System.out.println(localDate1);
        System.out.println(localDate2);
        System.out.println(localDate3);

    }

    @Test
    void getValue() {

        LocalDate localDate = LocalDate.now();

        System.out.println(localDate.getYear());
        System.out.println(localDate.getMonth());
        System.out.println(localDate.getMonthValue());
        System.out.println(localDate.getDayOfMonth());
        System.out.println(localDate.getDayOfWeek());
        System.out.println(localDate.getDayOfYear());
        System.out.println(localDate.getEra().getValue());
        System.out.println(localDate.getChronology().getCalendarType());
    }
}
