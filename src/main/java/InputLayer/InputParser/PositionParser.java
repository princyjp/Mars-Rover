package InputLayer.InputParser;

import InputLayer.CompassDirection;
import InputLayer.Position;

public class PositionParser {
private final String input;
public Position position;

    public PositionParser(String input) {
        this.input = input;
        position = parseToPosition();
    }

    private Position parseToPosition(){
        String[] inputArray;
        int x = 0;
        int y = 0;
        CompassDirection compassDirection = CompassDirection.N;
        if(input != null && !input.isBlank()) {
            if (input.matches("^\\d+\\s\\d+\\s[nsweNSWE]$")){
                inputArray = input.split(" ");
                x = Integer.parseInt(inputArray[0]);
                y = Integer.parseInt(inputArray[1]);
                compassDirection = new CompassDirectionParser(inputArray[2]).compassDirection;

            }
        }
        return new Position(x,y, compassDirection);
    }
}
