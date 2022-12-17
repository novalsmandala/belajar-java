package noval.mandala.lamda.app;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class RemoveIfApp {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.addAll(List.of("Noval", "Surya", "Mandala"));

        // for loop // solusi gagal
        //        for (var name : list) {
        //            if (name.length() > 5) {
        //                list.remove(name);
        //            }
        //        }

        // dengan anonymous class
        //        list.removeIf(new Predicate<String>() {
        //            @Override
        //            public boolean test(String value) {
        //                return value.length() > 5;
        //            }
        //        });

        // lambda
//        System.out.println(list.removeIf(nama -> nama.length() < 6));

        System.out.println(list);
    }
}
