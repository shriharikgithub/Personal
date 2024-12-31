package generics;

public class Pair<F, S> {
    F first;
    S second;
    Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    public F getFirst() {
        return first;
    }

    public S getSecond() {
        return second;
    }

    public void doSomethingOnFirst(String greeting) {
        System.out.println(greeting);
        System.out.println(first);

        System.out.println(second);
    }
}