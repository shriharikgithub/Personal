package multithreading.addersubtractor1;

import java.util.concurrent.Callable;

public class Adder implements Callable<Void> {

    Variable v;

    Adder(Variable v) {
        this.v = v;
    }

    @Override
    public Void call() throws Exception {
        for (int i = 0; i < 5000; i++) {
            synchronized (v) {
                ++v.x;
            }
        }
        return null;
    }
}