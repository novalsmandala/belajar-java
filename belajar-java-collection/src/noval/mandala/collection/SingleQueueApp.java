package noval.mandala.collection;

import noval.mandala.collection.collections.SingleQueue;

import java.util.Queue;

public class SingleQueueApp {

    public static void main(String[] args) {

        Queue<String> singleQueue = new SingleQueue();

        System.out.println(singleQueue.offer("Noval"));
        System.out.println(singleQueue.offer("Surya"));
        System.out.println(singleQueue.offer("Mandala"));
        System.out.println(singleQueue.size());

        System.out.println(singleQueue.peek());
        System.out.println(singleQueue.poll());
        System.out.println(singleQueue.poll());

        System.out.println(singleQueue.size());

    }
}
