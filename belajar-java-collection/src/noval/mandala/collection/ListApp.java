package noval.mandala.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListApp {
    public static void main(String[] args) {
        List<String> stringArrayList = new ArrayList<>();
        List<String> stringLinkedList = new LinkedList<>();

        stringArrayList.addAll(List.of("Noval", "Mandala"));
        stringArrayList.set(0, "Surya");
        System.out.println(stringArrayList.get(1));
    }
}
