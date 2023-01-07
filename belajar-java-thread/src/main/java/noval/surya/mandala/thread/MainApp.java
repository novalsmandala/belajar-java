package noval.surya.mandala.thread;

public class MainApp {

    public static void main(String[] args) {

        Thread thread = Thread.currentThread();

        System.out.println(thread.getName());
    }
}
