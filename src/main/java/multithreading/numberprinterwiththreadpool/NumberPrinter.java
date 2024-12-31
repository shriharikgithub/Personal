package multithreading.numberprinterwiththreadpool;

import java.util.concurrent.Callable;

public class NumberPrinter implements Runnable {

    int num;

    NumberPrinter(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        System.out.println("Number : " + num + ", from " + Thread.currentThread().getName());
    }
}
