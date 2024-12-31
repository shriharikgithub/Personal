package reflections;

public class SomethingDoer {

    private int x;

    public int y;

    private Object o1;

    public Object o2;

    public void doSomething() {
        System.out.println("Do something public");
    }

    private void doSomething2() {
        System.out.println("Do something private");
    }
}
