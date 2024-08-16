package InputLayer.InputParser;

import InputLayer.CompassDirection;
import InputLayer.Instruction;

public class CompassDirectionParser {
    private String input;
    CompassDirection compassDirection = CompassDirection.N;

    public CompassDirectionParser(String input) {
        this.input = input;
        compassDirection = inputValidation();
    }
    public CompassDirection inputValidation() {

        if (input != null && !input.isBlank()) {
            this.input = input.toUpperCase();
        } else {
            this.input = " ";
        }
        if (!input.isBlank()) {
            extractCompassDirection();
        }
        return compassDirection;
    }

    private void extractCompassDirection() {

            switch (input) {
                case "N":
                    compassDirection = CompassDirection.N;
                    break;

                case "S":
                    compassDirection = CompassDirection.S;
                    break;
                case "E":
                    compassDirection = CompassDirection.E;
                    break;
                case "W":
                    compassDirection = CompassDirection.W;
                    break;
                default:
                    System.out.println(input + " is an invalid Compass direction.");
                    break;

            }
    }
}
