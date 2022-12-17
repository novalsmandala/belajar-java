package programmer.zaman.now.application;

public class EqualsApp {
    public static void main(String[] args) {
        String first = "Noval";
        first = first + " " + "Mandala";
        System.out.println(first);
        String second = "Noval Mandala";
        System.out.println(second);
        System.out.println(first == second);
        System.out.println(first.equals(second));
        String third = "Noval Mandala";
        System.out.println(second == third);
        System.out.println(second.equals(third));
    }
}
