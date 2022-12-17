package noval.mandala.lamda.app;

import java.util.function.Consumer;

public class ConsumerApp {

    public static void main(String[] args) {

        // denan anonymous kelas
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String value) {
                System.out.println("Hello " + value);
            }   
        };

        consumer.accept("Noval");

        // dengan lambda
        consumer = value -> System.out.println("Hai " + value);

        consumer.accept("Mandala");
    }
}
