package noval.mandala.classes;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64App {
    public static void main(String[] args) {
        String query = "belajar() pemrograman() java()";

        String encoded = Base64.getEncoder().encodeToString(query.getBytes());
        System.out.println(encoded);
        byte[] bytes = Base64.getDecoder().decode(encoded);
        String decoded = new String(bytes);
        System.out.println(decoded);
    }
}
