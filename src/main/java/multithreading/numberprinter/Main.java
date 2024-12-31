package multithreading.numberprinter;



public class Main {
    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            Runnable r = new NumberPrinter(i);
            Thread t = new Thread(r);
            t.start();
        }
        System.out.println("Main thread finish");
    }
}
