package noval.mandala.test;

import org.junit.jupiter.api.*;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

@DisplayName("A Queue")
public class QueueTest {

    private Queue<String> queue;

    @Nested
    @DisplayName("when new")
    public class WhenNew{

        @BeforeEach
        void setUp() {
            queue = new LinkedList<>();
        }

        @Test
        @DisplayName("when offer, size must be 1")
        void offerNewData() {
            queue.offer("Noval");
            Assertions.assertEquals(1, queue.size());
        }

        @Test
        @DisplayName("when offer, size must be 2")
        void offerMoreData() {
            queue.offer("Noval");
            queue.offer("Mandala");
            Assertions.assertEquals(2, queue.size());
        }
    }
}
