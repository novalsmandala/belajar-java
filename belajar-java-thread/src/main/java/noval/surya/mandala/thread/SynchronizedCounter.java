package noval.surya.mandala.thread;

public class SynchronizedCounter {

    private Long value = 0L;

    public synchronized void increment() {
        value++;
    }

    public void incrementSynchronizedStatement() {
        synchronized (this) {
            value++;
        }
    }

    public Long getValue() {
        return value;
    }
}
