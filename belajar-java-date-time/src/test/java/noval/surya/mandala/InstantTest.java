package noval.surya.mandala;

import org.junit.jupiter.api.Test;

import java.time.*;

public class InstantTest {

    @Test
    void create() {

        Instant instant1 = Instant.now();
        System.out.println(instant1);

        Instant instant2 = Instant.ofEpochMilli(0);
        System.out.println(instant2);
    }

    @Test
    void modify() {

        Instant instant = Instant.now();

        System.out.println(instant.plusMillis(1000));
        System.out.println(instant.minusMillis(1000));
        System.out.println(instant.plusSeconds(100));
        System.out.println(instant.minusSeconds(100));

    }

    @Test
    void get(){

       Instant instant = Instant.now();

        System.out.println(instant.toEpochMilli());
        System.out.println(instant.getEpochSecond());
        System.out.println(instant.getNano());

    }

    @Test
    void fromInstant() {

        Instant instant = Instant.now();

        LocalTime localTime = LocalTime.ofInstant(instant, ZoneId.of("Asia/Jakarta"));
        System.out.println(localTime);

        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.of(
                "Asia/Jakarta"
        ));
        System.out.println(localTime);

        LocalDate localDate = LocalDate.ofInstant(instant, ZoneId.of("Asia/Jakarta"));
        System.out.println(localDate);

        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(instant, ZoneId.of("Asia/Jakarta"));
        System.out.println(zonedDateTime);

        OffsetDateTime offsetDateTime = OffsetDateTime.ofInstant(instant, ZoneId.of("Asia/Jakarta"));
        System.out.println(offsetDateTime);
    }

    @Test
    void toInstant() {

        Instant instant1 = LocalDateTime.now().toInstant(ZoneOffset.ofHours(7));
        Instant instant2 = ZonedDateTime.now().toInstant();

        System.out.println(instant1);
        System.out.println(instant2);

    }
}
