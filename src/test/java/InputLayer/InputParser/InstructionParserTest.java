package InputLayer.InputParser;

import InputLayer.Instruction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class InstructionParserTest {

    @Test
    @DisplayName("Return a valid instruction queue for a valid uppercase string")
    void test_InstructionParser_validUpperCase() {
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
    @Test
    @DisplayName("Return a valid instruction queue for a valid lowercase string")
    void test_InstructionParser_validLowerCase() {
        String instructions = "llmr";
        var instructionparser = new InstructionParser(instructions);
        var result = instructionparser.parseStringToInstruction();
        Queue<Instruction> expected = new LinkedList<>();
        expected.add(Instruction.L);
        expected.add(Instruction.L);
        expected.add(Instruction.M);
        expected.add(Instruction.R);
        assertEquals(expected,result);
    }
    @Test
    @DisplayName("Return a valid instruction queue for a valid mixed case string")
    void test_InstructionParser_validMixedCase() {
        String instructions = "lLmR";
        var instructionparser = new InstructionParser(instructions);
        var result = instructionparser.parseStringToInstruction();
        Queue<Instruction> expected = new LinkedList<>();
        expected.add(Instruction.L);
        expected.add(Instruction.L);
        expected.add(Instruction.M);
        expected.add(Instruction.R);
        assertEquals(expected,result);
    }
    @Test
    @DisplayName("Return a valid instruction queue for a input string with valid and invalid characters")
    void test_InstructionParser_MixedCharacters() {
        String instructions = "lLBmRa";
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