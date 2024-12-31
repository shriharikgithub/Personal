package adapterpattern.log4j;

public class Log4jAPI {

    public boolean out(String message) {
        System.out.println("Logging using Log4j: " + message);
        return true;
    }
}
