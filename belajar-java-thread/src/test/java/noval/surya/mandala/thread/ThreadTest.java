package noval.surya.mandala.thread;

import org.junit.jupiter.api.Test;

public class ThreadTest {

    @Test
    void mainThread() {

        String name = Thread.currentThread().getName();

        System.out.println(name);
    }

    @Test
    void createThread() {

        Runnable runnable = () -> System.out.println(
                "Hello from thread : " + Thread.currentThread().getName()
        );

        Thread thread = new Thread(runnable);
        thread.start();

        Thread thread2 = new Thread(runnable);
        thread2.start();

        Thread thread3 = new Thread(runnable);
        thread3.start();

        Thread thread4 = new Thread(runnable);
        thread4.start();

        System.out.println("Program selesai");

    }

    @Test
    void threadSleep() throws InterruptedException {

        Runnable runnable = () -> {
            try {
                Thread.sleep(2_000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(
                    "Hello from thread : " + Thread.currentThread().getName()
            );
        };

        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(3_000L);
        System.out.println("Program selesai");
    }

    @Test
    void threadJoin() throws InterruptedException {

        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                // manual check interrupted
                if (Thread.interrupted()) {
                    return;
                }
                System.out.println("Runable : " + i);
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println("Menunggu selesai ....");
        thread.join();
        System.out.println("Program selesai");
    }

    @Test
    void threadInterrupt() throws InterruptedException {

        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {

                System.out.println("Runnable : " + i);
                try {
                    Thread.sleep(1_000L);
                } catch (InterruptedException e) {
                    return;
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(5_000);
        thread.interrupt();
        System.out.println("Menunggu selesai ....");
        thread.join();
        System.out.println("Program selesai");
    }

    @Test
    void threadName() {

        var thread = new Thread(() -> {
            System.out.println("Run in thread : " + Thread.currentThread().getName());
        });

        thread.setName("Noval");
        thread.start();
    }

    @Test
    void thradState() throws InterruptedException {

        var thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getState());
            System.out.println("Run in thread : " + Thread.currentThread().getName());
        });

        thread.setName("Noval");
        System.out.println(thread.getState());

        thread.start();
        thread.join();
        System.out.println(thread.getState());

    }
}
