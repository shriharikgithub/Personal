package generics;

import builderpattern.Student;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> set = new LinkedHashSet<>();
        set.add(1);set.add(50);set.add(20);set.add(-1);set.add(50);
        for (Integer v : set) {
            System.out.println(v);
        }
    }
}
