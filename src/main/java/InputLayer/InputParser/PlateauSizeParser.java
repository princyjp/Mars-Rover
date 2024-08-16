package InputLayer.InputParser;

import InputLayer.CompassDirection;
import InputLayer.PlateauSize;

public class PlateauSizeParser {
    private final String input;
    private PlateauSize plateauSize;

    public PlateauSizeParser(String input) {
        this.input = input;
        plateauSize = parseToPlateauSize();
    }

    private PlateauSize parseToPlateauSize() {
        String[] inputArray;
        int length = 1;
        int breadth = 1;

        if(input != null && !input.isBlank()) {
            if (input.matches("^\\d+\\s\\d+$")){
                inputArray = input.split(" ");
                length = Integer.parseInt(inputArray[0]);
                breadth= Integer.parseInt(inputArray[1]);
            }
        }
        return new PlateauSize(length,breadth);
    }

    public PlateauSize getPlateauSize() {
        return plateauSize;
    }
}
