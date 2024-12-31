package multipleinheritancetest;

public class Main {
    public static void main(String[] args) {
        Parent p = new Child();
        p.test();

        NewInterface n = new Child();
        n.test();
    }
}
