package multithreading.producerconsumersemaphore;

import java.util.concurrent.Semaphore;

public class Consumer implements Runnable {

    Store store;
    Semaphore producerSemaphore;
    Semaphore consumerSemaphore;
    int consumerNumber;

    Consumer(Store store, Semaphore producerSemaphore, Semaphore consumerSemaphore, int consumerNumber) {
        this.store = store;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
        this.consumerNumber = consumerNumber;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (consumerSemaphore.availablePermits() == 1) {

                }
                consumerSemaphore.acquire();
                System.out.println("Consuming the item by consumer #" + consumerNumber);
                store.removeItem();
                producerSemaphore.release(2);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
