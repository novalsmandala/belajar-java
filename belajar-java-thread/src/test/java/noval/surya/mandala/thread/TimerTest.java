package noval.surya.mandala.thread;

import org.junit.jupiter.api.Test;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

public class TimerTest {

    @Test
    void delayedJob() throws InterruptedException {

        var task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Delayed Job");
            }
        };

        var timer = new Timer();
        timer.schedule(task, 2000);

        Thread.sleep(6000L);
    }

    @Test
    void periodicJob() throws InterruptedException {

        var task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Delayed Job");
            }
        };

        var timer = new Timer();
        timer.schedule(task, 2000L, 2000L);

        Thread.sleep(10_000);
    }
}
