package adapterpattern;

import adapterpattern.slf4j.SLF4jAPI;

public class SLF4jAdapter implements Logger {
    SLF4jAPI slf4jAPI = new SLF4jAPI();
    @Override
    public void log(String message) {
        slf4jAPI.printLog(message);
    }
}
