package InputLayer.InputParser;

import InputLayer.Instruction;
import InputLayer.PlateauSize;
import InputLayer.Position;

import java.util.Queue;

public class InputParser {
    private final String input;
    private PlateauSize plateauSize;
    private Position position;
    private Queue<Instruction> instructionsQueue;

    public InputParser(String input) {
        this.input = input;
        callParser();
    }

    private void callParser() {
        if (input.matches("^(\\d+(?:\\.\\d+)?)\\s(\\d+(?:\\.\\d+)?)$")){
            plateauSize = new PlateauSizeParser(input).getPlateauSize();
            System.out.println("Pateau size: " + plateauSize);
        }
        else if (input.matches("^\\d+\\s\\d+\\s[nsweNSWE]$"))
        {
            position = new PositionParser(input).position;
            System.out.println("Position: "+ position);
        }
        else{
            instructionsQueue = new InstructionParser(input).getInstructionsQueue();
            System.out.println("Instructions: " + instructionsQueue);
        }
    }

    public String getInput() {
        return input;
    }

    public PlateauSize getPlateauSize() {
        return plateauSize;
    }

    public Position getPosition() {
        return position;
    }

    public Queue<Instruction> getInstructionsQueue() {
        return instructionsQueue;
    }
}
