package InputLayer.InputParser;

import InputLayer.Instruction;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class InstructionParser {
    private String instructions;

    public InstructionParser(String instructions) {
        if(instructions != null || !instructions.isBlank() ) {
            this.instructions = instructions.toUpperCase();
        }else{
            this.instructions = " ";
        }
    }
    public Queue<Instruction> parseStringToInstruction(){
        Queue<Instruction> instructionQueue = new LinkedList<>();

        if(!instructions.isBlank()) {
            for (char c : instructions.toCharArray()) {
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
        return instructionQueue;
    }
}
