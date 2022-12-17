package noval.mandala.lamda.app;

import java.util.function.Supplier;

public class LazyApp {

    public static void main(String[] args) {
        testScore(50, () -> getName());
    }

    // menggunakan lazy paramaeter dengan lambda menggunakan Suplier
    public static void testScore (int value, Supplier<String> name) {

        if (value > 80) {
            System.out.println("Selamat " + name.get() + ", Anda Lulus");
        } else {
            System.out.println("Coba Lagi Tahun Depan");
        }
    }

    public static String getName () {
        System.out.println("getName() dipanggil");
        return "Eko";
    }
}
