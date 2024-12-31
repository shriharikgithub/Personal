package adapterpattern;

import adapterpattern.logger.LoggerAPI;

public class LoggerAdapter implements Logger {
    LoggerAPI loggerAPI = new LoggerAPI();
    @Override
    public void log(String message) {
        loggerAPI.sendStream(message);
    }
}
