package singletonpattern;

public class Singleton {

    private static Singleton INSTANCE;

    private String name;

    private Singleton() {
        this.name = "Test";
    }

    public static Singleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton();
        }
        return INSTANCE;
    }
}
