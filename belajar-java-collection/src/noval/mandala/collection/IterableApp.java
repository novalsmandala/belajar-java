package noval.mandala.collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IterableApp {
    public static void main(String[] args) {
        Iterable<String> names = List.of("Noval", "Surya", "Mandala");
        // menggunakan foreach diperkenalkan sejak java versi 5
        for (var name : names) {
            System.out.println(name);
        }

        // menggunakan iterator atau secara menual
        // hasNext untuk melihat data selanjutnya ada apa tidak dan mengembalikan nilai boolean
        // next method untuk mengembalikan nilai pada data selanjutnya

        System.out.println("ITERATOR");
        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
