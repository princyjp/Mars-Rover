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
        int maxX = 1;
        int maxY = 1;


        if(input != null && !input.isBlank()) {

            if (input.matches("^(\\d+(?:\\.\\d+)?)\\s(\\d+(?:\\.\\d+)?)$")){
                inputArray = input.split(" ");
                maxX = (int)Math.round(Double.parseDouble(inputArray[0]));
                maxY= (int)Math.round(Double.parseDouble(inputArray[1]));
                 if(maxX == 0 || maxY == 0){
                     maxX = 1;
                     maxY = 1;
                 }
            }
            else{
                System.out.println("Invalid Plateau size. Plateau size set to default value (1,1).");
            }
        }
        return new PlateauSize(maxX,maxY);
    }

    public PlateauSize getPlateauSize() {
        return plateauSize;
    }
}
