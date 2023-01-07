package noval.surya.mandala.thread;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrentMapTest {

    @Test
    void concurrentMap() throws InterruptedException {

        final var countDown = new CountDownLatch(20);
        final var map = new ConcurrentHashMap<Integer, String>();
        final var executor = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 2; i++) {
            final var index = i;
            executor.execute(() -> {
                try {
                    Thread.sleep(1000);
                    String put = map.put(index, "Data " + index);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDown.countDown();
                }
            });

            executor.execute( () -> {
                try {
                    countDown.await();
                    map.forEach((key, value) -> System.out.println(key + " : " + value));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            executor.awaitTermination(20, TimeUnit.SECONDS);

        }
    }

    @Test
    void testCollection() {

        List<String> list = List.of("Noval", "Surya", "Mandala");
        List<String> synchronizedList = Collections.synchronizedList(list);


    }
}
