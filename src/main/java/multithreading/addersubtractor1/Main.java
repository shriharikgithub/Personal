package multithreading.addersubtractor1;

import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newCachedThreadPool();
        Variable v = new Variable();
        Adder adder = new Adder(v);
        Subtractor subtractor = new Subtractor(v);
        Future<Void> f1 = es.submit(adder);
        Future<Void> f2 = es.submit(subtractor);
        f1.get();
        f2.get();
        System.out.println(v.x);

        Semaphore s = new Semaphore(1);
        es.shutdown();
    }
}
