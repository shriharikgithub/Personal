package singletonpattern;

public class SingletonV3 {

    private static SingletonV3 INSTANCE;
    private SingletonV3() {}

    public static SingletonV3 getInstance() {
        if (INSTANCE == null) {
            synchronized (SingletonV3.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SingletonV3();
                }
            }
        }
        return INSTANCE;
    }
}
