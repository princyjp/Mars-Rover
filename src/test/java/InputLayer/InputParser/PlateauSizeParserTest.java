package InputLayer.InputParser;

import InputLayer.PlateauSize;
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
                () -> assertEquals(1, result.getMaxX()),
                () -> assertEquals(2, result.getMaxY())
        );

    }

    @Test
    @DisplayName("Return a rounded up plateausize for decimal value")
    void test_plateauSizeParser_decimalInput() {
        String input = "16.545 2321.2";

        var result = new PlateauSizeParser(input).getPlateauSize();

        assertAll(
                () -> assertEquals(17, result.getMaxX()),
                () -> assertEquals(2321, result.getMaxY())
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
                () -> assertEquals(1, result1.getMaxX()), () -> assertEquals(1, result1.getMaxY()),
                () -> assertEquals(1, result2.getMaxX()), () -> assertEquals(1, result2.getMaxY()),
                () -> assertEquals(1, result3.getMaxX()), () -> assertEquals(1, result3.getMaxY()),
                () -> assertEquals(1, result4.getMaxX()), () -> assertEquals(1, result4.getMaxY()),
                () -> assertEquals(1, result5.getMaxX()), () -> assertEquals(1, result5.getMaxY()),
                () -> assertEquals(1, result6.getMaxX()), () -> assertEquals(1, result6.getMaxY()),
                () -> assertEquals(1, result7.getMaxX()), () -> assertEquals(1, result7.getMaxY()),
                () -> assertEquals(1, result8.getMaxX()), () -> assertEquals(1, result8.getMaxY()),
                () -> assertEquals(1, result9.getMaxX()), () -> assertEquals(1, result9.getMaxY()),
                () -> assertEquals(1, result10.getMaxX()), () -> assertEquals(1, result10.getMaxY())

        );

    }


}