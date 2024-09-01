package LogicLayer;

import InputLayer.CompassDirection;
import InputLayer.Instruction;
import InputLayer.PlateauSize;
import InputLayer.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class RoverTest {
    Rover rover;
    Position pos;
    Plateau plateau;
    int maxX;
    int maxY;
    Queue<Instruction> instructions = new LinkedList<>();

    @BeforeEach
    void setUp() {
        plateau = new Plateau(new PlateauSize(2, 2));
        maxX = plateau.getPlateauSize().getMaxX();
        maxY = plateau.getPlateauSize().getMaxY();
        instructions.add(Instruction.L);
        instructions.add(Instruction.L);
        instructions.add(Instruction.M);
        instructions.add(Instruction.R);

    }

    @Test
    @DisplayName("Return current position for start-position 0,0,N")
    void test_move_atZeroZero_facingNorth() {
        pos = new Position(0, 0, CompassDirection.N);
        rover = new Rover(plateau, pos, instructions);
        rover.runInstruction();
        assertEquals(0, rover.getCurrentPosition().getX());
        assertEquals(1, rover.getCurrentPosition().getY());

    }
    @Test
    @DisplayName("Return current position for start-position 0,0,S")
    void test_move_atZeroZero_facingSouth() {
        pos = new Position(0, 0, CompassDirection.S);
        rover = new Rover(plateau, pos, instructions);
        rover.runInstruction();
        assertEquals(0, rover.getCurrentPosition().getX());
        assertEquals(1, rover.getCurrentPosition().getY());
        assertEquals(CompassDirection.E, rover.getCurrentPosition().getFacing());

    }
    @Test
    @DisplayName("Return current position for start-position 0,0,E")
    void test_move_atZeroZero_facingEast() {
        pos = new Position(0, 0, CompassDirection.E);
        rover = new Rover(plateau, pos, instructions);
        rover.runInstruction();
        assertEquals(1, rover.getCurrentPosition().getX());
        assertEquals(0, rover.getCurrentPosition().getY());
        assertEquals(CompassDirection.S, rover.getCurrentPosition().getFacing());

    }
    @Test
    @DisplayName("Return current position for start-position 0,0,W")
    void test_move_atZeroZero_facingWest() {
        pos = new Position(0, 0, CompassDirection.W);
        rover = new Rover(plateau, pos, instructions);
        rover.runInstruction();
        assertEquals(1, rover.getCurrentPosition().getX());
        assertEquals(0, rover.getCurrentPosition().getY());
        assertEquals(CompassDirection.S, rover.getCurrentPosition().getFacing());
    }

    // Test cases fpr position (0,MaxY) in all directions
    @Test
    @DisplayName("Return current position for start-position 0,MaxY,N")
    void test_move_atZeroMaxY_facingNorth() {
        pos = new Position(0, maxY, CompassDirection.N);
        rover = new Rover(plateau, pos, instructions);
        rover.runInstruction();
        assertEquals(0, rover.getCurrentPosition().getX());
        assertEquals(1, rover.getCurrentPosition().getY());
        assertEquals(CompassDirection.W, rover.getCurrentPosition().getFacing());
    }
    @Test
    @DisplayName("Return current position for start-position 0,MaxY,S")
    void test_move_atZeroMaxY_facingSouth() {
        pos = new Position(0, maxY, CompassDirection.S);
        rover = new Rover(plateau, pos, instructions);
        rover.runInstruction();
        assertEquals(0, rover.getCurrentPosition().getX());
        assertEquals(1, rover.getCurrentPosition().getY());
        assertEquals(CompassDirection.W, rover.getCurrentPosition().getFacing());

    }
    @Test
    @DisplayName("Return current position for start-position 0,MaxY,E")
    void test_move_atZeroMaxY_facingEast() {
        pos = new Position(0, maxY, CompassDirection.E);
        rover = new Rover(plateau, pos, instructions);
        rover.runInstruction();
        assertEquals(1, rover.getCurrentPosition().getX());
        assertEquals(2, rover.getCurrentPosition().getY());
        assertEquals(CompassDirection.S, rover.getCurrentPosition().getFacing());

    }
    @Test
    @DisplayName("Return current position for start-position 0,MaxY,W")
    void test_move_atZeroMaxY_facingWest() {
        pos = new Position(0, maxY, CompassDirection.W);
        rover = new Rover(plateau, pos, instructions);
        rover.runInstruction();
        assertEquals(1, rover.getCurrentPosition().getX());
        assertEquals(2, rover.getCurrentPosition().getY());
        assertEquals(CompassDirection.S, rover.getCurrentPosition().getFacing());
    }
    //Other
    @Test
    @DisplayName("Return current position for start-position 1,0,S")
    void test_move_atOneZeroSouth() {
        pos = new Position(1, 0, CompassDirection.S);
        rover = new Rover(plateau, pos, instructions);
        rover.runInstruction();
        assertEquals(1, rover.getCurrentPosition().getX());
        assertEquals(1, rover.getCurrentPosition().getY());
        assertEquals(CompassDirection.E, rover.getCurrentPosition().getFacing());
    }

    @Test
    @DisplayName("Return current position for start-position 0,1,W")
    void test_move_atZeroOneWest() {
        pos = new Position(0, 1, CompassDirection.W);
        rover = new Rover(plateau, pos, instructions);
        rover.runInstruction();
        assertEquals(1, rover.getCurrentPosition().getX());
        assertEquals(1, rover.getCurrentPosition().getY());
        assertEquals(CompassDirection.S, rover.getCurrentPosition().getFacing());
    }
}