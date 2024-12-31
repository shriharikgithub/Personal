package generics;

import java.util.Arrays;
import java.util.List;

public class Assignment {

    public static <T> void exchange(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{10, 20};
        exchange(arr, 0, 1);
        System.out.println(Arrays.toString(arr));
    }
}
