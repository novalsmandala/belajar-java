package noval.mandala.lamda.app;

import java.util.function.Supplier;

public class SupplierApp {

    public static void main(String[] args) {

        // tanpa lambda
        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return "Gift";
            }
        };

        // dengan lambda
        supplier = () -> "Gift";

        System.out.println(supplier.get());

    }
}
