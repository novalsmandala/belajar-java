package noval.mandala.lamda.app;

import java.util.function.Predicate;

public class PredicateApp {

    public static void main(String[] args) {

        // tanpa lambda
        Predicate<String> predicateCheckBlank = new Predicate<String>() {
            @Override
            public boolean test(String value) {
                return value.isBlank();
            }
        };

        // dengan lambda
        predicateCheckBlank = value -> value.isBlank();

        System.out.println(predicateCheckBlank.test(""));
        System.out.println(predicateCheckBlank.test("Noval"));
    }
}
