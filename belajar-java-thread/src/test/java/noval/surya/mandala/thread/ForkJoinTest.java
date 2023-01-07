package noval.surya.mandala.thread;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ForkJoinTest {

    @Test
    void create() {

        var forkJoinPool1 = ForkJoinPool.commonPool();// semua cpu
        var forJoinPool2 = new ForkJoinPool(2);

        var executor1 = Executors.newWorkStealingPool(); // semua cpu
        var executor2 = Executors.newWorkStealingPool(3);
    }

    @Test
    void recursiveAction() throws InterruptedException {

//        var pool = ForkJoinPool.commonPool();
        var pool = new ForkJoinPool(2);
        List<Integer> integers = IntStream.range(0, 1000).boxed().collect(Collectors.toList());

        var task = new SimpleForkJoinTask(integers);

        pool.execute(task);

        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.MINUTES);
    }

    @Test
    void recursiveTask() throws InterruptedException, ExecutionException {

//        var pool = ForkJoinPool.commonPool();
        var pool = new ForkJoinPool(2);
        List<Integer> integers = IntStream.range(0, 1000).boxed().collect(Collectors.toList());

        var task = new TotalRecursiveTask(integers);
        ForkJoinTask<Long> submit = pool.submit(task);

        Long aLong = submit.get();

        System.out.println("Total : " + aLong);

        long sum = integers.stream().mapToLong(value -> value).sum();
        System.out.println("Must : " + sum);

        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.MINUTES);
    }

    @Test
    void testSpeed() {



        Assertions.assertTimeout(Duration.ofMillis(200), new Executable() {
            @Override
            public void execute() throws Throwable {
                for (int i = 0; i < 100000; i++) {

                    System.out.println("Loop ke : " + i);

                }
            }
        });
    }

    public static class SimpleForkJoinTask extends RecursiveAction {

        private List<Integer> list;

        public SimpleForkJoinTask(List<Integer> list) {
            this.list = list;
        }

        @Override
        protected void compute() {
            if (list.size() <= 10) {
                // execute
                doExecute();
            } else {
                // forkig
                forkCompute();
            }
        }

        public void doExecute() {
            list.forEach(integer -> {
                System.out.println(Thread.currentThread().getName() + " : " + integer);
            });
        }

        public void forkCompute() {
            List<Integer> integers1 = this.list.subList(0, this.list.size() / 2);
            List<Integer> integers2 = this.list.subList(this.list.size() / 2, this.list.size());

            SimpleForkJoinTask simpleForkJoinTask1 = new SimpleForkJoinTask(integers1);
            SimpleForkJoinTask simpleForkJoinTask2 = new SimpleForkJoinTask(integers2);

            ForkJoinTask.invokeAll(simpleForkJoinTask1, simpleForkJoinTask2);
        }
    }

    public static class  TotalRecursiveTask extends RecursiveTask<Long> {

        private List<Integer> integers;

        public TotalRecursiveTask(List<Integer> integers) {
            this.integers = integers;
        }

        @Override
        protected Long compute() {
            if (integers.size() <= 10) {
                return doCompute();
            } else {
                return forkComputer();
            }
        }

        private Long forkComputer() {

            List<Integer> integers1 = this.integers.subList(0, this.integers.size() / 2);
            List<Integer> integers2 = this.integers.subList(this.integers.size() / 2, this.integers.size());

            TotalRecursiveTask task1 = new TotalRecursiveTask(integers1);
            TotalRecursiveTask task2 = new TotalRecursiveTask(integers2);

            ForkJoinTask.invokeAll(task1, task2);

            return task1.join() + task2.join();
        }

        private Long doCompute() {
            return integers.stream().mapToLong(value -> value).peek( value -> {
                System.out.println(Thread.currentThread().getName() + " : " + value);
            }).sum();
        }
    }
}
