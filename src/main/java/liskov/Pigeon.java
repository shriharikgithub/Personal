package liskov;

public class Pigeon extends Bird implements FlyEatBird {

    @Override
    public void eat() {
        System.out.println( "I am pigeon, i am eating");
    }

    @Override
    public void fly() {
        System.out.println( "I am pigeon, i am flying");
    }
}
