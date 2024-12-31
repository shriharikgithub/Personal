package reflections;

public class DatabaseConnection {
    private boolean isAvailable;

    public DatabaseConnection() {
        isAvailable = true;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}