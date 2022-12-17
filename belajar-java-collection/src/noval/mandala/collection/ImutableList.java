package noval.mandala.collection;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImutableList {
    public static void main(String[] args) {

        List<String> one = Collections.singletonList("satu"); // mengembalikan satu list
        List<String> empety = Collections.emptyList(); // mengembalikan list kosong

        List<String> mutable = new ArrayList<>(); // list dapat di ubah
        mutable.add("Noval");
        mutable.add("Mandala");
        List<String> imutableList = Collections.unmodifiableList(mutable); // mengubah list menjadi mutable

        List<String> element = List.of("Noval", "Surya", "Mandala");
//        element.add("Erorr");

    }
}
