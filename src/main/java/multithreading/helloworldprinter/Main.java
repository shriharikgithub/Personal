package multithreading.helloworldprinter;

public class Main {
    public static void main(String[] args) {
        Runnable helloWorldPrinter = new HelloWorldPrinter();
        Thread t = new Thread(helloWorldPrinter);
        t.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {

        }
        System.out.println("Hi from " + Thread.currentThread().getName());
    }
}
