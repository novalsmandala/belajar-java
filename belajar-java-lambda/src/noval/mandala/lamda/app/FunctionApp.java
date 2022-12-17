package noval.mandala.lamda.app;

import java.util.function.Function;

public class FunctionApp {

    public static void main(String[] args) {

        // tanpa lambda
        Function<String, Integer> functionlength = new Function<String, Integer>() {
            @Override
            public Integer apply(String value) {
                return value.length();
            }
        };

        // dengan lambda
        functionlength = value -> value.length();

        System.out.println(functionlength.apply("Noval"));
    }
}
