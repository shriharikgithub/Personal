package singletonassignments;

import java.util.*;

public class ConnectionPoolImpl implements ConnectionPool {

    private static ConnectionPoolImpl instance;

    private DatabaseConnection[] databaseConnections;

    private int maxConnections;

    private ConnectionPoolImpl(int maxConnections) {
        this.maxConnections = maxConnections;
        initializePool();
    }

    public static ConnectionPoolImpl getInstance(int maxConnections) {
        if (instance == null) {
            synchronized(ConnectionPoolImpl.class) {
                if (instance == null) {
                    instance = new ConnectionPoolImpl(maxConnections);
                }
            }
        }
        return instance;
    }

    public void resetInstance() {
        this.databaseConnections = null;
        instance = null;
    }

    @Override
    public void initializePool() {
        databaseConnections = new DatabaseConnection[maxConnections];
        for (int i = 0; i < databaseConnections.length; i++) {
            databaseConnections[i] = new DatabaseConnection();
        }
    }

    @Override
    public DatabaseConnection getConnection() {
        Optional<DatabaseConnection> databaseConnection = Arrays.stream(databaseConnections)
        .filter(d -> d != null && d.isAvailable())
        .findFirst();
        if (databaseConnection.isPresent()) {
            databaseConnection.get().setAvailable(false);
            return databaseConnection.get();
        }
        return null;
    }

    @Override
    public void releaseConnection(DatabaseConnection connection) {
        connection.setAvailable(true);
    }

    @Override
    public int getAvailableConnectionsCount() {
        long ans = Arrays.stream(databaseConnections).filter(d ->  d != null && d.isAvailable()).count();
        return (int) ans;
    }

    @Override
    public int getTotalConnectionsCount() {
        return  databaseConnections != null ? databaseConnections.length : 0;
    }
}