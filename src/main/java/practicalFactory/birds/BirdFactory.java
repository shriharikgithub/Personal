package practicalFactory.birds;

public class BirdFactory {
    public Bird createObjectFromEnumType(BirdType birdType) {
        switch (birdType) {
            case HEN -> {
                return new Hen();
            }
            case CROW -> new Crow();
            case PARROT -> new Parrot();
            default -> new Bird();
        }
        return null;
    }
}
