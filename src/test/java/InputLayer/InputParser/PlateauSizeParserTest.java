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
        String input = "1.5 2.2";

        var result = new PlateauSizeParser(input).getPlateauSize();

        assertAll(
                () -> assertEquals(2, result.getLength()),
                () -> assertEquals(2, result.getBreadth())
        );

    }


}