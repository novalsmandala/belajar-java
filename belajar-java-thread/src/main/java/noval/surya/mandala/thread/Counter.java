package noval.surya.mandala.thread;

import java.util.Locale;

public class Counter {

    private Long value = 0L;

    public void increment() {
        value++;
    }

    public Long getValue() {
        return value;
    }
}
