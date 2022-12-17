package noval.mandala.lamda.app;

import noval.mandala.lamda.SimpleAction;

public class SimpleActionApp {

    public static void main(String[] args) {

        /* LAMBDA adalah versi sederhana dari anonymous class
        *  SYARAT :
        *  - Berupa Interface
        *  - Memiliki 1 Method Abstract
        *  - Ditambahkan annotation @FunctionInterface di Interface nya
        *  - Minimal menggunakan java 8
        */

        // menggunakan anonymous class
        //        SimpleAction simpleAction1 = new SimpleAction() {
        //            @Override
        //            public String action() {
        //                return "Noval";
        //            }
        //
        //        };
        //
        //        System.out.println(simpleAction1.action());
        //
        //        // menggunakan lambda
        //        SimpleAction simpleAction2 = () -> {
        //            return "Mandala";
        //        };

        // lamda dengan parameter dengan blok
        SimpleAction simpleAction3 = (String value) -> {
            return "Hello " + value;
        };

        SimpleAction simpleAction4 = (name) -> {
            return "Hello " + name;
        };

        // tanpa blok
        SimpleAction simpleAction5 = (String name) -> "Hello " + name;
        SimpleAction simpleAction6 = (name) -> "Hello " + name;
        SimpleAction simpleAction7 = name -> "Hello " + name;

        System.out.println(simpleAction6.action("Noval"));

    }
}
