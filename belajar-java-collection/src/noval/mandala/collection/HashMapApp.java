package noval.mandala.collection;

import java.util.HashMap;
import java.util.Map;

public class HashMapApp {
    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        map.put("name.first", "Noval");
        map.put("name.middle", "Surya");
        map.put("name.last", "Mandala");

        System.out.println(map.get("name.first"));
        System.out.println(map.get("name.middle"));
        System.out.println(map.get("name.last"));

        HashMap hashMap = new HashMap<>();
    }
}
