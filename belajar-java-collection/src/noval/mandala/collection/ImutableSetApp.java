package noval.mandala.collection;

import java.util.*;

public class ImutableSetApp {
    public static void main(String[] args) {

        Set<String> empty = Collections.emptySet();
        Set<String> one = Collections.singleton("one");

        Set<String> mutable = new LinkedHashSet<>(List.of(
           "Noval", "Surya", "Mandala"
        ));
        Set<String> imutable = Collections.unmodifiableSet(mutable);

        for (var name : imutable) {
            System.out.println(name);
        }

    }
}
