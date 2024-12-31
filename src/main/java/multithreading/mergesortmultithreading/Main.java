package multithreading.mergesortmultithreading;

import multithreading.mergesortmultithreading.MergeSort;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int[] arr = {8, 2, 4, 1, 9, 6, 0, 7};
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        CountDownLatch latch = new CountDownLatch(1); // Single main task
        MergeSort task = new MergeSort(arr, 0, arr.length - 1, executorService, latch);

        executorService.submit(task);
        latch.await(); // Wait for all tasks to finish

        System.out.println("Sorted Array: " + Arrays.toString(arr));
        executorService.shutdown();
    }
}
