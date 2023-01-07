package noval.surya.mandala.thread;

import java.util.Locale;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CounterLock {

    private Long value = 0L;

    final private Lock lock = new ReentrantLock();

    public void increment() {
        try {
            lock.lock();
            value++;
        } finally {
            lock.unlock();
        }
    }

    public Long getValue() {
        return value;
    }
}
