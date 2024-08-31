package InputLayer.InputParser;

import InputLayer.Instruction;


import java.util.LinkedList;
import java.util.Queue;

public class InstructionParser {
    private final String input;
    private Queue<Instruction> instructionQueue = new LinkedList<>();

    public InstructionParser(String input) {
        if (input != null && !input.isBlank()) {
            this.input = input.toUpperCase();
//            instructionQueue = parseToInstruction();
            extractInstruction();
        } else {
            this.input = " ";
        }
    }

    public Queue<Instruction> parseToInstruction() {

        if (!input.isBlank()) {
            extractInstruction();
        }
        return instructionQueue;
    }

    private void extractInstruction() {
        for (char c : input.toCharArray()) {
            switch (c) {
                case 'L':
                    instructionQueue.add(Instruction.L);
                    break;
                case 'R':
                    instructionQueue.add(Instruction.R);
                    break;
                case 'M':
                    instructionQueue.add(Instruction.M);
                    break;
                default:
                    System.out.println(c + " is an invalid instruction.");
                    break;

            }
        }
    }
    public Queue<Instruction> getInstructionsQueue() {
        return instructionQueue;
    }

}
