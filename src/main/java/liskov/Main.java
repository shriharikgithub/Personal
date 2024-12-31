package liskov;

public class Main {
    public static void main(String[] args) {
        Flyable b = new Pigeon();
        b.fly();
        Eatable c = new Pigeon();
        c.eat();

        FlyEatBird b1 = new Pigeon();
        b1.fly();
        b1.eat();
    }
}
