package noval.mandala.collection;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImutableApp {

    public static void main(String[] args) {

        Map<String, String> empty = Collections.emptyMap();
        Map<String, String> sigleton = Collections.singletonMap("Name", "Noval");

        // Mutable
        Map<String, String> map = new HashMap<>();
        map.put("name", "Noval");

        // Konversi ke Imutable
        Map<String, String> imutableMap = Collections.unmodifiableMap(map);

        // Imutable
        Map<String, String> imutable = Map.of(
                "nama", "Noval",
                "address", "Serang"
        );

    }
}
