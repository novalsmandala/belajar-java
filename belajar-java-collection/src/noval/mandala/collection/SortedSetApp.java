package noval.mandala.collection;

import noval.mandala.collection.data.Person;
import noval.mandala.collection.data.PersonComparator;

import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetApp {
    public static void main(String[] args) {

        SortedSet<Person> people = new TreeSet<>(new PersonComparator().reversed());
        people.add(new Person("Noval"));
        people.add(new Person("Surya"));
        people.add(new Person("Mandala"));

        for (var person : people) {
            System.out.println(person.getName());
        }

        // imutable sortedset
        SortedSet<Person> imutable = Collections.unmodifiableSortedSet(people);
    }
}
