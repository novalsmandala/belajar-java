package noval.mandala.classes;

import java.sql.SQLOutput;

public class SystemApp {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        System.out.println(System.nanoTime());
        System.out.println(System.getenv("PROCESSOR_LEVEL"));
        System.gc();

        System.exit(1);
    }
}
