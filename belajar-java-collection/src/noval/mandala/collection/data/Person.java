package noval.mandala.collection.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
        this.hobbies = new ArrayList<>();
    }

    private List<String> hobbies;

    public void addHobby(String hobby) {
        hobbies.add(hobby);
    }

    public List<String> getHobbies() {
//        return hobbies; // mutable
        return Collections.unmodifiableList(hobbies);
    }

    public String getName() {
        return name;
    }
}
