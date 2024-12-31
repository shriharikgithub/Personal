package multithreading.numberprinterwiththreadpool;


import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 1; i <= 100; i++) {
            if (i == 80) {
                System.out.println("STOP");
                break;
            }

            Runnable r = new NumberPrinter(i);
            executorService.execute(r);
        }
        List<Runnable> list = executorService.shutdownNow();
        for (Runnable l : list) {
            System.out.println(l);
        }
        System.out.println("Main thread finish");
    }
}
