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
        var result = new InstructionParser(instructions);

        Queue<Instruction> expected = new LinkedList<>();
        expected.add(Instruction.L);
        expected.add(Instruction.L);
        expected.add(Instruction.M);
        expected.add(Instruction.R);
        assertEquals(expected,result.getInstructionsQueue());
    }
    @Test
    @DisplayName("Return a valid instruction queue for a valid lowercase string")
    void test_InstructionParser_validLowerCase() {
        String instructions = "llmr";
        var result = new InstructionParser(instructions).getInstructionsQueue();

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
        var result = new InstructionParser(instructions).getInstructionsQueue();

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
        String instructions1 = "lLBmRa";
        String instructions2 = "lLBmRa@";
        String instructions3 = "l1LBm23Ra@";
        var result1 = new InstructionParser(instructions1).getInstructionsQueue();
        var result2 = new InstructionParser(instructions2).getInstructionsQueue();
        var result3 = new InstructionParser(instructions3).getInstructionsQueue();

        Queue<Instruction> expected = new LinkedList<>();
        expected.add(Instruction.L);
        expected.add(Instruction.L);
        expected.add(Instruction.M);
        expected.add(Instruction.R);

        assertAll(
                ()-> assertEquals(expected,result1),
                ()-> assertEquals(expected,result2),
                ()-> assertEquals(expected,result3)
        );

    }
    @Test
    @DisplayName("Return a empty instruction queue for invalid input")
    void test_InstructionParser_invalidInput() {
        String instructions1 = null;
        String instructions2 = "";
        String instructions3 = "  ";
        String instructions4 = "abc4@j";
        var result1 = new InstructionParser(instructions1).getInstructionsQueue();
        var result2 = new InstructionParser(instructions2).getInstructionsQueue();
        var result3 = new InstructionParser(instructions3).getInstructionsQueue();
        var result4 = new InstructionParser(instructions4).getInstructionsQueue();

        Queue<Instruction> expected = new LinkedList<>();
        assertAll(
                ()-> assertEquals(expected,result1),
                ()-> assertEquals(expected,result2),
                ()-> assertEquals(expected,result3),
                ()-> assertEquals(expected,result4)
        );

    }
}