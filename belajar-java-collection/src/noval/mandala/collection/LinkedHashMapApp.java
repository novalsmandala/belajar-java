package noval.mandala.collection;

import com.sun.security.jgss.GSSUtil;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LinkedHashMapApp {
    public static void main(String[] args) {

        Map<String, String> map = new LinkedHashMap<>();
        map.put("first", "Noval");
        map.put("last", "Mandala");
        map.put("middle", "Surya");

        Set<String> keys = map.keySet();

        for (var key : keys) {
            System.out.println(key);
        }
    }
}
