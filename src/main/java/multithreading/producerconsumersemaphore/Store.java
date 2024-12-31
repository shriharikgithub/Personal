package multithreading.producerconsumersemaphore;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Store {
    Queue<Object> list;
    int maxItems;

    Store(int maxItems) {
        this.maxItems = maxItems;
        list = new ConcurrentLinkedQueue<>();
    }

    public void addItem(Object x) throws Exception {
        list.add(x);
        if (list.size() > maxItems) {
            throw new Exception("Gone crazy");
        }
    }

    public void removeItem() throws Exception {
        if (list.size() <= 0) {
            throw new Exception("Cannot remove");
        }
        list.remove();
    }
}
