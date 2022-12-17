package noval.mandala.collection;

import java.util.Collections;
import java.util.NavigableMap;
import java.util.TreeMap;

public class NavigableMapApp {
    public static void main(String[] args) {

        NavigableMap<String, String> navigableMap = new TreeMap<>();
        navigableMap.put("name", "Noval");
        navigableMap.put("address", "Serang");
        navigableMap.put("school", "SMKN 3 Kendal");

        for (var key : navigableMap.keySet()) {
            System.out.println(key);
        }

        System.out.println(navigableMap.lowerKey("name"));
        System.out.println(navigableMap.higherKey("name"));
        System.out.println(navigableMap.lowerEntry("name"));
        System.out.println(navigableMap.higherEntry("name"));
        System.out.println(navigableMap.floorKey("Noval"));
        System.out.println(navigableMap.ceilingKey("Noval"));

        NavigableMap<String, String> mapDesc = navigableMap.descendingMap();

        for (var key : navigableMap.keySet()) {
            System.out.println(key);
        }

        // NavigableMap kosong
        NavigableMap<String, String> empty = new TreeMap<>();

        // NavigableMap imutable
        NavigableMap<String, String> imutable = Collections.unmodifiableNavigableMap(navigableMap);

    }
}
