package multithreading.addersubtractor2locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ExecutorService es = Executors.newCachedThreadPool();
        Variable v = new Variable();
        Lock lock = new ReentrantLock();
        Adder adder = new Adder(v, lock);
        Subtractor subtractor = new Subtractor(v, lock);
        Future<Void> f1 = es.submit(adder);
        Future<Void> f2 = es.submit(subtractor);
        try {
            f1.get();f2.get();
        } catch (Exception e) {

        } finally {
            es.shutdown();
        }
        long end = System.currentTimeMillis();
        System.out.println(v.x);
        System.out.println(" Time taken : " + (end - start));
    }
}
