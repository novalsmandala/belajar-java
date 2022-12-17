package noval.mandala.lamda.app;

import javax.swing.*;
import java.util.List;
import java.util.function.Consumer;

public class ForEachApp {

    public static void main(String[] args) {

        List<String> list = List.of("Noval", "Surya", "Mandala");

        // menggunakan for loop
        for (var value : list) {
            System.out.println(value);
        }

        // menggunakan anonymous class
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String value) {
                System.out.println(value);
            }
        });

        // menggunakan lambda
        list.forEach(value -> System.out.println(value));

        // menggunakan lambda method reference
        list.forEach(System.out::println);


    }
}
