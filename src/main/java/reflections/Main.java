//package reflections;
//
//import java.io.*;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//public class Main {
//    public static void main(String[] args) throws NoSuchFieldException, IOException {
//        SomethingDoer somethingDoer = new SomethingDoer();
//
//        Writer fileWriter = new FileWriter("Test.log");
//
//        PrintWriter writer = new PrintWriter(fileWriter);
//
//        writer.write("AVC");
//
//        writer.flush();
//
//        writer.close();
//
//        DatabaseConnection[] databaseConnections = new DatabaseConnection[10];
//
//        int databaseConnection = Arrays.stream(databaseConnections).filter(d -> d.isAvailable()).count();
//
//
//    }
//}
