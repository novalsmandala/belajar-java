package noval.mandala.collection;

import javax.swing.tree.TreeNode;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class MapDefaultMethodApp {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        map.put("Noval", "Noval value");
        map.put("Surya", "Surya value");
        map.put("Mandala", "Mandala value");

        map.forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String s, String s2) {
                System.out.println(s + " : " + s2);
            }
        });

    }
}
