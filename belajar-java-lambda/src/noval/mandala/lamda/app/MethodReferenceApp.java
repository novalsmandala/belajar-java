package noval.mandala.lamda.app;

import noval.mandala.lamda.util.StringUtil;

import java.util.function.Function;
import java.util.function.Predicate;

public class MethodReferenceApp {

    public static void main(String[] args) {

        //        Predicate<String> predicateIsLowerCase = value -> StringUtil.isLowerCase(value);
        // menggunakann method reference
        // tergantung juga pada .util.function
        Predicate<String> predicateIsLowerCase = StringUtil::isLowerCase;

        System.out.println(predicateIsLowerCase.test("noval"));
        System.out.println(predicateIsLowerCase.test("Noval"));

        // Method Reference di Parameter
        //        Function<String, String> functionUpper = new Function<String, String>() {
        //            @Override
        //            public String apply(String value) {
        //                return value.toUpperCase();
        //            }
        //        };

        //        Function<String, String> functionUpper = value -> value.toUpperCase();

        Function<String, String> functionUpper = String::toUpperCase;

        System.out.println(functionUpper.apply("noval"));
    }

    public void run () {

        //        Predicate<String> predicateIsLowerCase = new Predicate<String>() {
        //            @Override
        //            public boolean test(String value) {
        //                return MethodReferenceApp.this.isLowerCase(value);
        //            }
        //        };

        //        Predicate<String> predicateIsLowerCase = value -> MethodReferenceApp.this.isLowerCase(value);

        //        Predicate<String> predicateIsLowerCase = this::isLowerCase;

        MethodReferenceApp app = new MethodReferenceApp();

        // bisa dengan nama objek
        // pakai this jika di kelas yang sama
        Predicate<String> predicateIsLowerCase = app::isLowerCase;

        System.out.println(predicateIsLowerCase.test("noval"));
        System.out.println(predicateIsLowerCase.test("Noval"));
    }

    public boolean isLowerCase(String value) {
        for (var c : value.toCharArray()) {
            if (!Character.isLowerCase(c)) {
                return false;
            }
        }

        return true;
    }
}
