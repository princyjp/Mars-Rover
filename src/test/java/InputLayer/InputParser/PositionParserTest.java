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
    @DisplayName("Return a valid position for a valid input string")
    void test_positionParser_validUpperCase() {
        String input = "1 2 N";

        Position result = new PositionParser(input).position;
        ;
        Position expected = new Position(1, 2, CompassDirection.N);
        assertAll(
                () -> assertEquals(expected.getX(), result.getX()),
                () -> assertEquals(expected.getY(), result.getY()),
                () -> assertEquals(expected.getFacing(), result.getFacing())
        );

    }

    @Test
    @DisplayName("Return a valid position for a valid input string in lowercase")
    void test_positionParser_validLowerCase() {
        String input = "15 2 e";

        Position result = new PositionParser(input).position;
        ;
        Position expected = new Position(15, 2, CompassDirection.E);
        assertAll(
                () -> assertEquals(expected.getX(), result.getX()),
                () -> assertEquals(expected.getY(), result.getY()),
                () -> assertEquals(expected.getFacing(), result.getFacing())
        );

    }

    @Test
    @DisplayName("Return a default position [0,0,N] for an invalid input string")
    void test_positionParser_invalidInput() {
        String input1 = null;
        String input2 = "";
        String input3 = "  ";
        String input4 = "32 44 z";
        String input5 = "32 g";
        String input6 = "3 6 ";
        String input7 = "3";
        String input8 = "3 3 WW";
        String input9 = "3 3 W$";

        Position result1 = new PositionParser(input1).position;
        Position result2 = new PositionParser(input1).position;
        Position result3 = new PositionParser(input1).position;
        Position result4 = new PositionParser(input1).position;
        Position result5 = new PositionParser(input1).position;
        Position result6 = new PositionParser(input1).position;
        Position result7 = new PositionParser(input1).position;
        Position result8 = new PositionParser(input1).position;
        Position result9 = new PositionParser(input1).position;

        Position expected = new Position(0, 0, CompassDirection.N);
        assertAll(
                () -> assertEquals(expected.getX(), result1.getX()),
                () -> assertEquals(expected.getY(), result1.getY()),
                () -> assertEquals(expected.getFacing(), result1.getFacing()),

                () -> assertEquals(expected.getX(), result2.getX()),
                () -> assertEquals(expected.getY(), result2.getY()),
                () -> assertEquals(expected.getFacing(), result2.getFacing()),

                () -> assertEquals(expected.getX(), result3.getX()),
                () -> assertEquals(expected.getY(), result3.getY()),
                () -> assertEquals(expected.getFacing(), result3.getFacing()),

                () -> assertEquals(expected.getX(), result4.getX()),
                () -> assertEquals(expected.getY(), result4.getY()),
                () -> assertEquals(expected.getFacing(), result4.getFacing()),

                () -> assertEquals(expected.getX(), result5.getX()),
                () -> assertEquals(expected.getY(), result5.getY()),
                () -> assertEquals(expected.getFacing(), result5.getFacing()),

                () -> assertEquals(expected.getX(), result6.getX()),
                () -> assertEquals(expected.getY(), result6.getY()),
                () -> assertEquals(expected.getFacing(), result6.getFacing()),

                () -> assertEquals(expected.getX(), result7.getX()),
                () -> assertEquals(expected.getY(), result7.getY()),
                () -> assertEquals(expected.getFacing(), result7.getFacing()),

                () -> assertEquals(expected.getX(), result8.getX()),
                () -> assertEquals(expected.getY(), result8.getY()),
                () -> assertEquals(expected.getFacing(), result8.getFacing()),

                () -> assertEquals(expected.getX(), result9.getX()),
                () -> assertEquals(expected.getY(), result9.getY()),
                () -> assertEquals(expected.getFacing(), result9.getFacing())
        );

    }

}