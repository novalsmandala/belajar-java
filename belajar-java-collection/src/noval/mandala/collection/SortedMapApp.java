package noval.mandala.collection;

import noval.mandala.collection.data.Person;

import java.util.Collections;
import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapApp {
    public static void main(String[] args) {

        Comparator<String> stringComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // reverse tinggal di balik
                return o2.compareTo(o1);
            }
        };

        SortedMap<String, String> sortedMap = new TreeMap<>(stringComparator);

        // untuk sorted map yang sudah defaultnya sudah ada comparator di String
        sortedMap.put("name", "Noval Surya Mandala");
        sortedMap.put("address", "Serang");
        sortedMap.put("school", "SMKN 3 Kendal");

        for (var key : sortedMap.keySet()) {
            System.out.println(key);
        }

        // SortedMap kosong
        SortedMap<String, String> empty = Collections.emptySortedMap();

        // SortedMap imutable
        SortedMap<String, String> imutable = Collections.unmodifiableSortedMap(sortedMap);

    }
}
