package InputLayer.InputParser;

public class CompassDirectionParser {
    private final String compassDirection;

    public CompassDirectionParser(String compassDirection) {
        if (compassDirection != null && !compassDirection.isBlank()) {
            this.compassDirection = compassDirection.toUpperCase();
        } else {
            this.compassDirection = " ";
        }

    }
}
