package multithreading.assignment2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayCreator arrayCreator = new ArrayCreator(n, executorService);
        Future<ArrayList<Integer>> future = executorService.submit(arrayCreator);
        System.out.println(future.get());
        executorService.shutdown();
    }
}
