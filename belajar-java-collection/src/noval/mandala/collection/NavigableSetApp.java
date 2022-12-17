package noval.mandala.collection;

import java.util.Collections;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

public class NavigableSetApp {
    public static void main(String[] args) {

        NavigableSet<String> names = new TreeSet<>();
        names.addAll(List.of("Noval", "Surya", "Mandala"));

        NavigableSet<String> namesReverse = names.descendingSet();

        NavigableSet<Character> abjad = new TreeSet<>();
        abjad.addAll(List.of('a', 'b', 'c', 'x', 'y', 'z'));

        abjad = abjad.descendingSet();
        NavigableSet<Character> characters = abjad.headSet('c', true);

        for (var name : names) {
            System.out.println(name);
        }

        System.out.println("REVERSE NAME");

        for (var name: namesReverse) {
            System.out.println(name);
        }

        for (var character : characters) {
            System.out.println(character);
        }

        // membuat imutable navigableset
        NavigableSet<String> navigableSet = Collections.unmodifiableNavigableSet(names);

        // mebuat navigableset yang kosong
        NavigableSet<String> navigableSetEmpty = Collections.emptyNavigableSet();

    }
}
