package singletonpattern;

public class SingletonV2 {
    private static SingletonV2 INSTANCE = new SingletonV2();

    private String name;

    private SingletonV2() {
        this.name = "Test";
    }

    public static SingletonV2 getInstance() {
        return INSTANCE;
    }
}
