package singletonassignments;

public class DatabaseConnection {
    private boolean isAvailable;

    public DatabaseConnection() {
        isAvailable = true;
    }

    public synchronized void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public synchronized boolean isAvailable() {
        return isAvailable;
    }
}