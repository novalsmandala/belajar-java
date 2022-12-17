package noval.mandala.collection;

import java.util.Hashtable;
import java.util.Map;

public class HashTableApp {

    public static void main(String[] args) {

        Map<String, String> map = new Hashtable<>();

        map.put("name", "Noval");
        map.put("address", "Serang");
        map.put("school", "SMKN 3 Kendal");

        for (var key : map.keySet()) {
            System.out.println(key);
        }

    }
}
