package noval.mandala.lamda.app;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

public class OptionalApp {

    public static void main(String[] args) {

        sayHello("Noval");

        String name = null;
        sayHello(name);
    }

    public static void sayHello (String name) {
        //        String nameUpper = name.toUpperCase();
        //        System.out.println("Hello " + nameUpper);

        // menggunakan Optinal dan lambda
        //        Optional<String> optionalName = Optional.ofNullable(name);
        //
        //        Optional<String> optionalNameUpper = optionalName.map(value -> value.toUpperCase());
        //
        //        optionalNameUpper.ifPresent(value -> System.out.println("Hello " + value));

        // lebih simpel atau satu chain
        //        Optional.ofNullable(name)
        //                .map(String::toUpperCase)
        //                .ifPresentOrElse(value -> System.out.println("Hello " + value),
        //                        () -> System.out.println("Hello"));

        String upperName = Optional.ofNullable(name)
                .map(String::toUpperCase)
                .orElse("TEMAN");

        System.out.println("Hello " + upperName);

        // menggunakan if-else check
        //        if (name != null) {
        //            String upperName = name.toUpperCase();
        //            System.out.println("Hello " + upperName);
        //        }

    }
}
