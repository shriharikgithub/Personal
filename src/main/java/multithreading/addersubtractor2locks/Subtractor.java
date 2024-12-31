package multithreading.addersubtractor2locks;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

public class Subtractor implements Callable<Void> {

    Variable v;

    Lock lock;

    Subtractor(Variable v, Lock lock) {
        this.v = v;
        this.lock = lock;
    }

    @Override
    public Void call() throws Exception {
        for (int i = 0; i < 5000; i++) {
            lock.lock();
            --v.x;
            lock.unlock();
        }
        return null;
    }
}
