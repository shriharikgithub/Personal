package multithreading.assignment;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class TreeSizeCalculator implements Callable<Integer> {

    private Node root;

    private ExecutorService es;

    TreeSizeCalculator(Node root, ExecutorService es) {
        this.root = root;
        this.es = es;
    }

    @Override
    public Integer call() throws ExecutionException, InterruptedException {
        if (root == null) {
            return 0;
        }
        int size = 1;
        TreeSizeCalculator leftTreeSize = new TreeSizeCalculator(root.left, es);
        Future<Integer> leftFuture = es.submit(leftTreeSize);
        TreeSizeCalculator rightTreeSize = new TreeSizeCalculator(root.right, es);
        Future<Integer> rightFuture = es.submit(rightTreeSize);
        size += leftFuture.get() + rightFuture.get();
        return size;
    }
}