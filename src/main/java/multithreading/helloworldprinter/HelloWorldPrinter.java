package multithreading.helloworldprinter;

import java.util.concurrent.Callable;

public class HelloWorldPrinter implements Runnable, Callable {

    @Override
    public void run() {
        System.out.println("Hello World from " + Thread.currentThread().getName());
    }

    @Override
    public Object call() throws Exception {
        return null;
    }
}
