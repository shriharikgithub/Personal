package multithreading.assignment2;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

public class ArrayCreator implements Callable<ArrayList<Integer>> {

    private int n;

    private ExecutorService es;

    public ArrayCreator(int n, ExecutorService es) {
        this.n = n;
        this.es = es;
    }

    @Override
    public ArrayList<Integer> call() throws Exception {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1 ; i <= n; i++) {
            list.add(i);
        }
        return list;
    }
}
