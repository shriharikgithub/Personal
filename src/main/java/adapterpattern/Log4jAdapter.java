package adapterpattern;

import adapterpattern.log4j.Log4jAPI;

public class Log4jAdapter implements Logger {
    Log4jAPI log4jAPI = new Log4jAPI();
    @Override
    public void log(String message) {
        log4jAPI.out(message);
    }
}
