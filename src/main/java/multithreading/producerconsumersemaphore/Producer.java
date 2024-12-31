package multithreading.producerconsumersemaphore;

import java.util.concurrent.Semaphore;

public class Producer implements Runnable {
    Store store;
    int producerNumber;
    Semaphore producerSemaphore;
    Semaphore consumerSemaphore;

    Producer(Store store, Semaphore producerSemaphore, Semaphore consumerSemaphore, int producerNumber) {
        this.store = store;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;;
        this.producerNumber = producerNumber;
    }

    @Override
    public void run() {
        try {
            while (true) {
                producerSemaphore.acquire();
                System.out.println("Producing the item by producer #" + producerNumber);
                store.addItem(new Object());
                consumerSemaphore.release();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
