package singletonpattern;

import java.io.*;

public class SerializationTest {
    public static void main(String[] args) throws Exception {
        SingletonV4 instance1 = SingletonV4.INSTANCE;

        System.out.println(instance1.hashCode());

        // Serialize the enum to a file
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton.ser"));
        oos.writeObject(instance1);
        oos.close();

        // Deserialize from the file
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("singleton.ser"));
        SingletonV4 instance2 = (SingletonV4) ois.readObject();
        ois.close();

        // Here, instance1 and instance2 point to the same object

        System.out.println(instance2.hashCode());
        System.out.println(instance1 == instance2); // true
    }
}