package InputLayer.InputParser;

import InputLayer.Instruction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class InstructionParserTest {

    @Test
    @DisplayName("Return a valid instruction queue for a valid input string")
    void parseStringToInstruction() {
        String instructions = "LLMR";
        var instructionparser = new InstructionParser(instructions);
        var result = instructionparser.parseStringToInstruction();
        Queue<Instruction> expected = new LinkedList<>();
        expected.add(Instruction.L);
        expected.add(Instruction.L);
        expected.add(Instruction.M);
        expected.add(Instruction.R);
        assertEquals(expected,result);
    }
}