package streams;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 10));
//        list.stream()
//                .filter(v -> v % 2 == 0)
//                .forEach(v -> System.out.println(v * 2));

//        list.stream()
//                .map(v -> v * 7)
//                .filter(v -> v > 30)
//                .forEach(System.out::println);
//

//        int sum1 = list.stream()
//                .filter(v -> v % 2 == 0)
//                .reduce(
//                0,
//                        (sum, v) -> sum + v
//        );
//        System.out.println(sum1);


        int max = list
                .stream()
                .reduce(Integer.MIN_VALUE,
                        (maxSoFar, v) -> Math.max(maxSoFar, v)
                        );

        List<Integer> l = list.stream().toList();


        long count = list.stream().count();
//        System.out.println(count);

        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        try {
            for (int i = 0; i <= Integer.MAX_VALUE; i++) {
                list.add(i);
            }
        } catch (Exception e) {
            System.out.println("Readhed");
        }

    }
}
