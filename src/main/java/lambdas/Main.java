package lambdas;

public class Main {
    public static void main(String[] args) {

        // v1
        Runnable somethingDoer = new SomethingDoer();
        Thread thread = new Thread(somethingDoer);
        thread.start();

        Runnable r = () -> {
            System.out.println("Do something v2");
        };

        Thread t2 = new Thread(r);
        t2.start();


        Stack s = () -> {
            return 1;
        };
    }
}
