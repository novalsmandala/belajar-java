package noval.mandala.collection;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueApp {
    public static void main(String[] args) {

        // Queue<String> queue = new ArrayDeque<>();
        // Queue<String> queue = new PriorityQueue<>();
        Queue<String> queue = new LinkedList<>();

        queue.add("Noval");
        queue.add("Surya");
        queue.add("Mandala");

        for (String next = queue.poll(); next != null; next = queue.poll()) {
            System.out.println(next + " item remains " + queue.size());
        }

        Queue<String> stringQueue = new ArrayDeque<>(10);

        for (int i = 0; i < 10; i++) {
            stringQueue.add(String.valueOf(i));
        }

        for (String next = stringQueue.poll(); next != null; next = stringQueue.poll()) {
            System.out.println(next + " item remain " + stringQueue.size());
        }

    }
}
