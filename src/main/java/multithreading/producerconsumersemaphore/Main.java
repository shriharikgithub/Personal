package multithreading.producerconsumersemaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        int max = 5;
        Store store = new Store(max);
        Semaphore producerSemaphore = new Semaphore(max);
        Semaphore consumerSemaphore = new Semaphore(0);
        ExecutorService es = Executors.newCachedThreadPool();
        for (int i = 0; i < 3; i++) {
            Producer p = new Producer(store, producerSemaphore, consumerSemaphore, i + 1);
            es.execute(p);
        }
        for (int i = 0; i < 100; i++) {
            Consumer c = new Consumer(store, producerSemaphore, consumerSemaphore, i + 1);
            es.execute(c);
        }
        es.shutdown();
    }
}
