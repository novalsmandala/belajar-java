package noval.mandala.i18n;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatTest {

    @Test
    void testDateFormat() {

        var pattern = "EEEE ss MMMM yyyy";
        var dateFormat = new SimpleDateFormat(pattern);

//        System.out.println(new Date());

        String format = dateFormat.format(new Date());

        System.out.println(format);
    }

    @Test
    void testDateFormatIndonesia() {

        var pattern = "EEEE ss MMMM yyyy";
        Locale indonesia = new Locale("id", "ID");
        var dateFormat = new SimpleDateFormat(pattern, indonesia);

//        System.out.println(new Date());

        String format = dateFormat.format(new Date());

        System.out.println(format);
    }

    @Test
    void testDateFormatJapan() {

        var pattern = "EEEE ss MMMM yyyy";
        Locale indonesia = new Locale("ja", "JP");
        var dateFormat = new SimpleDateFormat(pattern, indonesia);

//        System.out.println(new Date());

        String format = dateFormat.format(new Date());

        System.out.println(format);
    }

    @Test
    void testDateFormatParseIndonesia() {

        var pattern = "EEEE ss MMMM yyyy";
        Locale indonesia = new Locale("id", "ID");
        var dateFormat = new SimpleDateFormat(pattern, indonesia);

        try {
            var date = dateFormat.parse("Rabu 03 Maret 2021");
            System.out.println(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testDateFormatParseJapan() {

        var pattern = "EEEE ss MMMM yyyy";
        Locale indonesia = new Locale("ja", "JP");
        var dateFormat = new SimpleDateFormat(pattern, indonesia);

        try {
            var date = dateFormat.parse("金曜日 50 12月 2022");
            System.out.println(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


    }
}
