package noval.mandala.collection;

import java.util.IdentityHashMap;
import java.util.Map;

public class IdentityHashMapApp {
    public static void main(String[] args) {
        String key1 = "name.first";

        String name = "name";
        String first = "first";

        String key2 = name + "." + first;

        // cek apakah key1 dan key2 sama menggunakan equals dan ==
        System.out.println(key1.equals(key2));
        System.out.println(key1 == key2);

        Map<String, String> map = new IdentityHashMap<>();
        map.put(key1, "Noval");
        map.put(key2, "Noval");

        System.out.println(map.size());
    }
}
