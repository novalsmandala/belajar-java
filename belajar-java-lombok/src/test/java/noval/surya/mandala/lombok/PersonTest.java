package noval.surya.mandala.lombok;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class PersonTest {

    @Test
    void testViaConstructor() {

        var list = new ArrayList<String>();
        list.add("music");
        list.add("coding");
        var person = new Person("id", "name", 10, list);
    }

    @Test
    void createViaSetter() {

        var list = new ArrayList<String>();
        list.add("music");
        list.add("coding");
        var person = new Person();
        person.setId("id");
        person.setName("name");
        person.setAge(18);
        person.setHobbies(list);

        System.out.println(person);
    }

    @Test
    void createViaBuilder() {

        var list = new ArrayList<String>();
        list.add("music");
        list.add("coding");

        var person = Person.builder()
                .id("id")
                .name("name")
                .age(19)
                .hobbies(list)
                .build();

        System.out.println(person);
    }

    @Test
    void createViaBuilderWithSingular() {

//        var person = Person.builder()
//                .id("id")
//                .name("name")
//                .age(19)
////                .hobby("Traveling")
////                .hobby("Masak")
////                .hobby("Nglayap")
//                .build();
//
//        System.out.println(person);
    }
}
