package InputLayer.InputParser;

import InputLayer.CompassDirection;
import InputLayer.Instruction;
import InputLayer.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class PositionParserTest {
    @Test
    @DisplayName("Return a valid CompassDirection for a valid input string")
    void test_positionParser_validUpperCase() {
        String input = "1 2 N";

        Position result = new PositionParser(input).position; ;
       Position expected = new Position(1,2, CompassDirection.N);
       assertAll(
               ()-> assertEquals(expected.getX(),result.getX()),
               ()-> assertEquals(expected.getY(),result.getY()),
               ()-> assertEquals(expected.getFacing(),result.getFacing())
       );

    }
    @Test
    @DisplayName("Return a valid CompassDirection for a valid input string in lowercase")
    void test_positionParser_validLowerCase() {
        String input = "1 2 e";

        Position result = new PositionParser(input).position; ;
        Position expected = new Position(1,2, CompassDirection.E);
        assertAll(
                ()-> assertEquals(expected.getX(),result.getX()),
                ()-> assertEquals(expected.getY(),result.getY()),
                ()-> assertEquals(expected.getFacing(),result.getFacing())
        );

    }

}