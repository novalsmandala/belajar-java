package noval.mandala.collection;

import noval.mandala.collection.data.Person;

import java.util.List;

public class MutableApp {
    public static void main(String[] args) {
        Person person = new Person("Noval");

        // percobaan menambah list pada mutable list
        person.addHobby("Game");
        person.addHobby("Music");

        // memanggil method do soemthing with hobbies
        doSomethingWithHobbies(person.getHobbies());

        // menampilkan data pada list person
        for (var hobby : person.getHobbies()) {
            System.out.println(hobby);
        }
    }

    public static void doSomethingWithHobbies(List<String> hobbies) {
        /* permasalahan mutable list adalah ketika kita menambah suatu list
        * di metho lain itu akan membingungkan karena sebaiknya kita hanya bisa menambahnya
        * di bawah deklarasinya*/
//        hobbies.add("Bukan Hobby");
    }
}
