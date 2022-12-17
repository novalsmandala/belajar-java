package noval.mandala.collection;

import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapApp {
    public static void main(String[] args) {

        // weak hashmap menghapus data - data yang tidak terpakai saat garbage colection dijalankan
        Map<Integer, Integer> hashMap = new WeakHashMap<>();

        // input 1.000.000 data
        for (int i = 0; i < 1_000_000; i++) {
            hashMap.put(i, i);
        }

        // coba menjalankan garbage collection
        System.gc();
        System.gc();
        System.gc();
        System.gc();

        // check apakah setelah garbage collection dijalaknkan ada data yang terhapus
        System.out.println(hashMap.size());;
    }
}
