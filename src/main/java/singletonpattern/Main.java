package singletonpattern;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {


    public static void main(String[] args) {
        Set<Object> set = new HashSet<>();

        Runnable r = () -> System.out.println(SingletonV4.INSTANCE.hashCode());

        ExecutorService executorService = Executors.newFixedThreadPool(100);

        for (int i = 0 ; i <= 100; i++) {
            executorService.execute(r);
        }
        executorService.shutdown();

//        Runnable r = () -> {
//            Singleton singleton = Singleton.getInstance();
//            set.add(singleton);
//        };
//        ExecutorService executorService = Executors.newFixedThreadPool(100);
////        for (int i = 0 ; i <= 100; i++) {
////            executorService.execute(r);
////        }
////        executorService.shutdown();
////
////
////        r = () -> {
////            SingletonV2 singletonV2 = SingletonV2.getInstance();
////            set.add(singletonV2);
////        };
////
////        ExecutorService executorService2 = Executors.newFixedThreadPool(100);
////
////        for (int i = 0; i <= 100; i++) {
////            executorService2.execute(r);
////        }
////
////
////        executorService2.shutdown();
//
//
//        r = () -> {
//            SingletonV3 singleton = SingletonV3.getInstance();
//            set.add(singleton);
//        };
//        executorService = Executors.newFixedThreadPool(100);
//        for (int i = 0 ; i <= 100; i++) {
//            executorService.execute(r);
//        }
//        executorService.shutdown();
//
//        System.out.println(set);
//
//        Byte[] arr = new Byte[]{1,2,3};
//        System.out.println(Arrays.toString(arr));



    }
}
