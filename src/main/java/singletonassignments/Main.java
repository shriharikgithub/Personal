package singletonassignments;

public class Main {
    public static void main(String[] args) {
        ConnectionPoolImpl connectionPool = ConnectionPoolImpl.getInstance(5);
        connectionPool.getConnection();
        System.out.println(connectionPool.getAvailableConnectionsCount());

    }
}
