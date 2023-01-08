package noval.surya.mandala;

import org.junit.jupiter.api.Test;

import java.time.*;

public class ClockTest {

    @Test
    void create() {

        Clock clock1 = Clock.systemUTC();
        System.out.println(clock1);

        Clock clock2 = Clock.systemDefaultZone();
        System.out.println(clock2);

        Clock clock3 = Clock.system(ZoneId.of("Asia/Jakarta"));
        System.out.println(clock3);
    }

    @Test
    void instant() throws Throwable {

        Clock clock = Clock.system(ZoneId.of("Asia/Jakarta"));

        Instant instant1 = clock.instant();
        System.out.println(instant1);

        Thread.sleep(1000);

        Instant instant2 = clock.instant();
        System.out.println(instant2);
    }

    @Test
    void fromClock() {

        Clock clockJakarta = Clock.system(ZoneId.of("Asia/Jakarta"));

        Year  year = Year.now(clockJakarta);
        YearMonth yearMonth = YearMonth.now(clockJakarta);
        MonthDay monthDay = MonthDay.now(clockJakarta);
        LocalTime localTime = LocalTime.now(clockJakarta);
        LocalDateTime localDateTime = LocalDateTime.now(clockJakarta);
        OffsetTime offsetTime = OffsetTime.now(clockJakarta);
        OffsetDateTime now = OffsetDateTime.now(clockJakarta);
        ZonedDateTime zonedDateTime = ZonedDateTime.now(clockJakarta);

        System.out.println(year);
        System.out.println(yearMonth);
        System.out.println(monthDay);
        System.out.println(localTime);
        System.out.println(localDateTime);
        System.out.println(offsetTime);
        System.out.println(now);
        System.out.println(zonedDateTime);
    }
}
