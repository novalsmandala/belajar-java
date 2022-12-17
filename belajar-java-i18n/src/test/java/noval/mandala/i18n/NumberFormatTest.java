package noval.mandala.i18n;

import org.junit.jupiter.api.Test;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class NumberFormatTest {

    @Test
    void testNumberFormat() {

        var numberFormat = NumberFormat.getInstance();
        String format = numberFormat.format(10000000.255);

        System.out.println(format);
    }

    @Test
    void testNumberFormatIndonesia() {

        Locale indonesia = new Locale("id", "ID");
        var numberFormat = NumberFormat.getInstance(indonesia);
        String format = numberFormat.format(10000000.255);

        System.out.println(format);
    }

    @Test
    void testNumberFormatParseIndonesia(){

        Locale indonesia = new Locale("in", "ID");
        var numberFormat = NumberFormat.getInstance(indonesia);

        try {
            var result = numberFormat.parse("10.000.000,255").doubleValue();
            System.out.println(result);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }
}
