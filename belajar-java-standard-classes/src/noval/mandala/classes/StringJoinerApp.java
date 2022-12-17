package noval.mandala.classes;

import java.util.StringJoiner;

public class StringJoinerApp {
    public static void main(String[] args) {
        StringJoiner joiner = new StringJoiner(", ", "{", "}");
        joiner.add("Noval");
        joiner.add("Surya");
        joiner.add("Mandala");
        String value = joiner.toString();
        System.out.println(value);
    }
}
