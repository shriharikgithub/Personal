package multithreading.assignment3;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            Thread t = new Thread(new TableCreator(i));
            t.start();
        }
    }
}
