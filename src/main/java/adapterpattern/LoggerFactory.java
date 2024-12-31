package adapterpattern;

public class LoggerFactory {
    public static <T extends Logger> Logger getLogger(Class<T> type) {
        if (type == Log4jAdapter.class) {
            return new Log4jAdapter();
        } else if (type == LoggerAdapter.class) {
            return new LoggerAdapter();
        } else if (type == SLF4jAdapter.class) {
            return new SLF4jAdapter();
        } else {
            throw new IllegalArgumentException("Invalid logger type");
        }
    }
}
