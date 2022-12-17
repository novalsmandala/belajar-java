package noval.mandala.classes;

import java.util.Calendar;
import java.util.Date;
import java.util.spi.CalendarNameProvider;

public class DateApp {
    public static void main(String[] args) {
        Date tanggal = new Date();
        System.out.println(tanggal);

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, 10);
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_WEEK, 0) ;

        Date date = calendar.getTime();
        System.out.println(date);

        System.out.println(System.getenv());
    }
}
