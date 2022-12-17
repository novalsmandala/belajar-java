package noval.mandala.collection;

import java.util.List;
import java.util.Vector;

public class VectorApp {

    public static void main(String[] args) {

        List<String> list = new Vector<>();
        list.add("Noval");
        list.add("Surya");
        list.add("Mandala");

        for (var name: list) {
            System.out.println(name);
        }
    }
}
