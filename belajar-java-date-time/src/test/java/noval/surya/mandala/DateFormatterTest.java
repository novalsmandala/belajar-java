package noval.surya.mandala;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateFormatterTest {

    @Test
    void parsing() {

        LocalDate localDate = LocalDate.parse("2004-11-28");
        System.out.println(localDate);

        // custom formater
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
        LocalDate dateFormatted = LocalDate.parse("2020 12 20", formatter);
        System.out.println(dateFormatted);
    }

    @Test
    void format() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate dateFormatted = LocalDate.parse("2020/12/20", formatter);

        String format = dateFormatted.format(formatter);
        System.out.println(format);
    }

    @Test
    void defaultFormatter() {

        // pattern yang diterima
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        // memparsing sesuai dengan data yang ingin diminta
        LocalDate localDate = LocalDate.parse("28-11-2004", formatter);

        // memformat sesuai dengan format yang diminta
        String formated = localDate.format(DateTimeFormatter.ISO_LOCAL_DATE);

        System.out.println(formated);

    }

    @Test
    void i18n() {

        Locale locale = new Locale("ja", "JP");

        // pattern yang diterima
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MMMM dd", locale);

        // memparsing sesuai dengan data yang ingin diminta
        LocalDate localDate = LocalDate.now();

        // memformat sesuai dengan format yang diminta
        String formated = localDate.format(formatter);

        System.out.println(formated);

    }
}
