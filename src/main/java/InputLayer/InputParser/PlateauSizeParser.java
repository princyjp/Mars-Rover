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

            if (input.matches("^(\\d+(?:\\.\\d+)?)\\s(\\d+(?:\\.\\d+)?)$")){
                inputArray = input.split(" ");
                length = (int)Math.round(Double.parseDouble(inputArray[0]));
                breadth= (int)Math.round(Double.parseDouble(inputArray[1]));
                 if(length == 0 || breadth == 0){
                     length = 1;
                     breadth = 1;
                 }
            }
            else{
                System.out.println("Invalid Plateau size. Plateau size set to default value (1,1).");
            }
        }
        return new PlateauSize(length,breadth);
    }

    public PlateauSize getPlateauSize() {
        return plateauSize;
    }
}
