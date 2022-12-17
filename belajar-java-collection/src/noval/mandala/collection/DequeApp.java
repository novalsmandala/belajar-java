package noval.mandala.collection;

import java.awt.desktop.QuitEvent;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class DequeApp {
    public static void main(String[] args) {

        Deque<String> deque = new LinkedList<>();
        deque.add("Noval");
        deque.add("Surya");
        deque.add("Mandala");
        deque.add("Paling");
        deque.add("Ganteng");

        // mengambil data akhir dengan pollLast yaitu LIFO
        for (String next = deque.pollLast(); next != null; next = deque.pollLast()) {
            System.out.println(next + " item remain " + deque.size());
        }

        // atau dengan menggunakan offerLast
        deque.offerLast("Mandala");
        deque.offerLast("Surya");
        deque.offerLast("Noval");

        for (var name : deque) {
            System.out.println(name + " item remain " + deque.size());
        }

        // Model Antrian
        Deque<String> queue = new LinkedList<>();
        queue.offerLast("Noval");
        queue.offerFirst("Surya");
        queue.offerLast("Mandala");

        System.out.println(queue.pollFirst());
        System.out.println(queue.pollFirst());
        System.out.println(queue.pollFirst());

    }
}
