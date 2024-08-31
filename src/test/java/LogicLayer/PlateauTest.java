package LogicLayer;

import InputLayer.PlateauSize;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlateauTest {

    @Test
    void isPositionOutOfBounds() {
        new Plateau(new PlateauSize(15,15));
    }

    @Test
    void isPositionEmpty() {
    }
}