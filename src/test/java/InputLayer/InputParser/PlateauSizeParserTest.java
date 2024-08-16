package InputLayer.InputParser;

import InputLayer.CompassDirection;
import InputLayer.PlateauSize;
import InputLayer.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlateauSizeParserTest {
    @Test
    @DisplayName("Return a valid plateausize for a valid input string")
    void test_plateauSizeParser_validInput() {
        String input = "1 2";

        var result = new PlateauSizeParser(input).getPlateauSize();

        assertAll(
                () -> assertEquals(1, result.getLength()),
                () -> assertEquals(2, result.getBreadth())
        );

    }

    @Test
    @DisplayName("Return a rounded up plateausize for decimal value")
    void test_plateauSizeParser_decimalInput() {
        String input = "16.545 2321.2";

        var result = new PlateauSizeParser(input).getPlateauSize();

        assertAll(
                () -> assertEquals(17, result.getLength()),
                () -> assertEquals(2321, result.getBreadth())
        );
//consider including decimal point value and rounding it up to nearest integer (1.,2.3)
    }

    @Test
    @DisplayName("Return a default position [1,1] for an invalid input string")
    void test_positionParser_invalidInput() {
        String input1 = null;
        String input2 = "";
        String input3 = "  ";
        String input4 = "32 44 z";
        String input5 = "1. 20";
        String input6 = "3 6 ";
        String input7 = "3 -9";
        String input8 = "0 0";
        String input9 = "9 0.0";
        String input10 = "0.1 0.9";

        PlateauSize result1 = new PlateauSizeParser(input1).getPlateauSize();
        PlateauSize result2 = new PlateauSizeParser(input2).getPlateauSize();
        PlateauSize result3 = new PlateauSizeParser(input3).getPlateauSize();
        PlateauSize result4 = new PlateauSizeParser(input4).getPlateauSize();
        PlateauSize result5 = new PlateauSizeParser(input5).getPlateauSize();
        PlateauSize result6 = new PlateauSizeParser(input6).getPlateauSize();
        PlateauSize result7 = new PlateauSizeParser(input7).getPlateauSize();
        PlateauSize result8 = new PlateauSizeParser(input8).getPlateauSize();
        PlateauSize result9 = new PlateauSizeParser(input9).getPlateauSize();
        PlateauSize result10 = new PlateauSizeParser(input10).getPlateauSize();

        assertAll(
                () -> assertEquals(1, result1.getLength()), () -> assertEquals(1, result1.getBreadth()),

                () -> assertEquals(1, result2.getLength()), () -> assertEquals(1, result2.getBreadth()),

                () -> assertEquals(1, result3.getLength()), () -> assertEquals(1, result3.getBreadth()),

                () -> assertEquals(1, result4.getLength()), () -> assertEquals(1, result4.getBreadth()),

                () -> assertEquals(1, result5.getLength()), () -> assertEquals(1, result5.getBreadth()),

                () -> assertEquals(1, result6.getLength()), () -> assertEquals(1, result6.getBreadth()),

                () -> assertEquals(1, result7.getLength()), () -> assertEquals(1, result7.getBreadth()),
                () -> assertEquals(1, result8.getLength()), () -> assertEquals(1, result8.getBreadth()),
                () -> assertEquals(1, result9.getLength()), () -> assertEquals(1, result9.getBreadth()),
                () -> assertEquals(1, result10.getLength()), () -> assertEquals(1, result10.getBreadth())

        );

    }


}