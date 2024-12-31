package multithreading.leetcode;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class ZeroEvenOdd {
    private int n;
    
    private boolean callOdd;
    
    private int x;
    
    private Semaphore zeroSemaphore, oddSemaphore, evenSemaphore;
    
    public ZeroEvenOdd(int n) {
        this.n = n;
        callOdd = true;
        zeroSemaphore = new Semaphore(1);
        oddSemaphore = new Semaphore(0);
        evenSemaphore = new Semaphore(0);
        this.x = 1;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        zeroSemaphore.acquire();
        printNumber.accept(0);
        if (callOdd) {
            oddSemaphore.release();
        } else {
            evenSemaphore.release();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        evenSemaphore.acquire();
        printNumber.accept(x);
        x++;
        callOdd = true;
        zeroSemaphore.release();
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        oddSemaphore.acquire();
        printNumber.accept(x);
        x++;
        callOdd = false;
        zeroSemaphore.release();
    }
}