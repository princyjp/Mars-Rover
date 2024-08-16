package LogicLayer;

import InputLayer.CompassDirection;
import InputLayer.Instruction;
import InputLayer.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class RoverTest {
    Rover rover;
    Position pos = new Position(0,0, CompassDirection.N);
    Queue<Instruction> instructions = new LinkedList<>();
    @BeforeEach
    void setUp() {

        instructions.add(Instruction.L);
        instructions.add(Instruction.L);
        instructions.add(Instruction.M);
        instructions.add(Instruction.R);
        rover = new Rover(pos,instructions);
    }

    @Test
    void test_move() {
        rover.move();
        assertEquals(0,rover.getCurrentPosition().getX());
        assertEquals(1,rover.getCurrentPosition().getY());

    }

    @Test
    void test_rotate() {


        rover.rotate(Instruction.L);
        assertEquals(CompassDirection.N,rover.getCurrentPosition().getFacing());

    }
}