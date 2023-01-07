package noval.surya.mandala.thread;

public class DaemonApp {

    public static void main(String[] args) throws InterruptedException {

        var thread = new Thread(() -> {
            try {
                Thread.sleep(3_00L);
                System.out.println("Run Thread");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.setDaemon(true);
        thread.start();


    }
}
