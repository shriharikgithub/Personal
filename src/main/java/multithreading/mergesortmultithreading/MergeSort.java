package multithreading.mergesortmultithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

public class MergeSort implements Runnable {

    int[] arr;
    int left;
    int right;
    ExecutorService executorService;
    CountDownLatch latch;

    MergeSort(int[] arr, int left, int right, ExecutorService executorService, CountDownLatch latch) {
        this.arr = arr;
        this.left = left;
        this.right = right;
        this.executorService = executorService;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            if (left >= right) {
                return;
            }
            int mid = left + (right - left) / 2;
            CountDownLatch subTaskLatch = new CountDownLatch(2);

            executorService.submit(new MergeSort(arr, left, mid, executorService, subTaskLatch));
            executorService.submit(new MergeSort(arr, mid + 1, right, executorService, subTaskLatch));

            // Wait for both subtasks to complete
            subTaskLatch.await();
            merge(mid);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            latch.countDown(); // Mark this task as complete
        }
    }

    private void merge(int mid) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        for (i = 0; i < temp.length; i++) {
            arr[left + i] = temp[i];
        }
    }
}
