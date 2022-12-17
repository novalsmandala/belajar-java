package noval.mandala.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CollectionApp {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();

        collection.add("Noval");
        collection.add("Surya");
        collection.add("Mandala");
        collection.addAll(List.of("Noval", "Mandala"));
        for (var name : collection) {
            System.out.println(name);
        }

        System.out.println("REMOVE");
        collection.remove("Noval");
        collection.removeAll(List.of("Eko", "Joko"));
        collection.remove("Eko");
        for (var name : collection) {
            System.out.println(name);
        }

        System.out.println("Cek apakah data ada");
        System.out.println(collection.contains("Mandala"));
        System.out.println(collection.contains("Eko"));
        System.out.println(collection.containsAll(List.of("Surya", "Mandala")));
    }
}
