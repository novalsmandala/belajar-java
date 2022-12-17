package noval.mandala.classes;

import java.util.Arrays;

public class StringApp {
    public static void main(String[] args) {
        String name = "Noval Surya Mandala";
        System.out.println(name);

        String nameLowercase = name.toLowerCase();
        System.out.println(nameLowercase);

        String nameUppercase = name.toUpperCase();
        System.out.println(nameUppercase);

        System.out.println(name.length());
        System.out.println(name.startsWith("Noval"));
        System.out.println(name.endsWith("Mandala"));

        String[] names = name.split(" ");
        System.out.println(Arrays.toString(names));

        System.out.println(" ".isBlank());
        System.out.println(" ".isEmpty());
        System.out.println("".isEmpty());
        System.out.println(name.charAt(0));

        char[] chars = name.toCharArray();
        for (var achar : chars){
            System.out.println(achar);
        }

        System.out.println(Arrays.toString(chars));
    }
}
