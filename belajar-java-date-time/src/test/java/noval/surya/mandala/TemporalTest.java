package noval.surya.mandala;

import com.sun.source.tree.BreakTree;
import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.temporal.*;
import java.util.ArrayList;
import java.util.List;

public class TemporalTest {

    @Test
    void temporal() {

        Temporal temporal1 = LocalDate.now();
        Temporal temporal2 = LocalTime.now();
        Temporal temporal3 = LocalDateTime.now();
        Temporal temporal4 = OffsetTime.now();
        Temporal temporal5 = OffsetDateTime.now();

    }

    @Test
    void temporalAmout() {

        Temporal temporal1 = LocalDateTime.now();
        Temporal temporal2 = temporal1.plus(Duration.ofHours(10));
        Temporal temporal3 = temporal1.plus(Period.of(10, 10, 10));

        System.out.println(temporal1);
        System.out.println(temporal2);
        System.out.println(temporal3);

    }

    @Test
    void temporalUnit() {

        long temporalUnit1 = ChronoUnit.HOURS.between(LocalTime.now(), LocalTime.now().plusHours(3));
        System.out.println(temporalUnit1);

        long temporalUnit2 = ChronoUnit.DAYS.between(LocalDateTime.now(), LocalDateTime.now().plusHours(10));
        System.out.println(temporalUnit2);

    }

    @Test
    void temporalField() {

        Temporal temporal = LocalDateTime.now();

        System.out.println(temporal.get(ChronoField.YEAR));
        System.out.println(temporal.get(ChronoField.MONTH_OF_YEAR));
        System.out.println(temporal.get(ChronoField.DAY_OF_MONTH));
        System.out.println(temporal.get(ChronoField.HOUR_OF_DAY));
        System.out.println(temporal.get(ChronoField.MINUTE_OF_HOUR));
        System.out.println(temporal.get(ChronoField.SECOND_OF_MINUTE));
        System.out.println(temporal.get(ChronoField.MILLI_OF_SECOND));
        System.out.println(temporal.get(ChronoField.NANO_OF_SECOND));

    }

    @Test
    void temporalQuery() {

        Temporal temporal = LocalDateTime.now();

        List<Integer> integers = temporal.query(new TemporalQuery<List<Integer>>() {
            @Override
            public List<Integer> queryFrom(TemporalAccessor temporal) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(temporal.get(ChronoField.YEAR));
                list.add(temporal.get(ChronoField.MONTH_OF_YEAR));
                list.add(temporal.get(ChronoField.DAY_OF_MONTH));
                list.add(temporal.get(ChronoField.HOUR_OF_DAY));
                return list;
            }
        });

        integers.forEach(integer -> System.out.println(integer));

    }

    @Test
    void temporalAjuster() {

        Temporal temporal1 = LocalDate.now();

        Temporal temporal2 = temporal1.with(new TemporalAdjuster() {
            @Override
            public Temporal adjustInto(Temporal temporal) {
                return LocalDate.of(temporal.get(ChronoField.YEAR),
                        temporal.get(ChronoField.MONTH_OF_YEAR),
                        temporal.get(ChronoField.DAY_OF_MONTH)
                );
            }
        });

        System.out.println(temporal1);
        System.out.println(temporal2);

        Temporal temporal3 = temporal1.with(TemporalAdjusters.firstDayOfMonth());
        Temporal temporal4 = temporal1.with(TemporalAdjusters.lastDayOfMonth());

        System.out.println(temporal3);
        System.out.println(temporal4);
    }
}
