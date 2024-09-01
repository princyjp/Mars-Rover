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
        plateau = new Plateau(new PlateauSize(3, 4));
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
        assertEquals(maxY-1, rover.getCurrentPosition().getY());
        assertEquals(CompassDirection.W, rover.getCurrentPosition().getFacing());
    }
    @Test
    @DisplayName("Return current position for start-position 0,MaxY,S")
    void test_move_atZeroMaxY_facingSouth() {
        pos = new Position(0, maxY, CompassDirection.S);
        rover = new Rover(plateau, pos, instructions);
        rover.runInstruction();
        assertEquals(0, rover.getCurrentPosition().getX());
        assertEquals(maxY-1, rover.getCurrentPosition().getY());
        assertEquals(CompassDirection.W, rover.getCurrentPosition().getFacing());

    }
    @Test
    @DisplayName("Return current position for start-position 0,MaxY,E")
    void test_move_atZeroMaxY_facingEast() {
        pos = new Position(0, maxY, CompassDirection.E);
        rover = new Rover(plateau, pos, instructions);
        rover.runInstruction();
        assertEquals(1, rover.getCurrentPosition().getX());
        assertEquals(maxY, rover.getCurrentPosition().getY());
        assertEquals(CompassDirection.S, rover.getCurrentPosition().getFacing());

    }
    @Test
    @DisplayName("Return current position for start-position 0,MaxY,W")
    void test_move_atZeroMaxY_facingWest() {
        pos = new Position(0, maxY, CompassDirection.W);
        rover = new Rover(plateau, pos, instructions);
        rover.runInstruction();
        assertEquals(1, rover.getCurrentPosition().getX());
        assertEquals(maxY, rover.getCurrentPosition().getY());
        assertEquals(CompassDirection.S, rover.getCurrentPosition().getFacing());
    }
    // Test cases for position (maxX,0) in all directions
    @Test
    @DisplayName("Return current position for start-position maxX,0,N")
    void test_move_atMaxXZero_facingNorth() {
        pos = new Position(maxX,0, CompassDirection.N);
        rover = new Rover(plateau, pos, instructions);
        rover.runInstruction();
        assertEquals(maxX, rover.getCurrentPosition().getX());
        assertEquals(1, rover.getCurrentPosition().getY());
        assertEquals(CompassDirection.E, rover.getCurrentPosition().getFacing());
    }
    @Test
    @DisplayName("Return current position for start-position maxX,0,S")
    void test_move_atMaxXZero_facingSouth() {
        pos = new Position(maxX,0, CompassDirection.S);
        rover = new Rover(plateau, pos, instructions);
        rover.runInstruction();
        assertEquals(maxX, rover.getCurrentPosition().getX());
        assertEquals(1, rover.getCurrentPosition().getY());
        assertEquals(CompassDirection.E, rover.getCurrentPosition().getFacing());

    }
    @Test
    @DisplayName("Return current position for start-position maxX,0,E")
    void test_move_atMaxXZero_facingEast() {
        pos = new Position(maxX,0, CompassDirection.E);
        rover = new Rover(plateau, pos, instructions);
        rover.runInstruction();
        assertEquals(maxX-1, rover.getCurrentPosition().getX());
        assertEquals(0, rover.getCurrentPosition().getY());
        assertEquals(CompassDirection.N, rover.getCurrentPosition().getFacing());

    }
    @Test
    @DisplayName("Return current position for start-position maxX,0,W")
    void test_move_atMaxXZero_facingWest() {
        pos = new Position(maxX,0, CompassDirection.W);
        rover = new Rover(plateau, pos, instructions);
        rover.runInstruction();
        assertEquals(maxX-1, rover.getCurrentPosition().getX());
        assertEquals(0, rover.getCurrentPosition().getY());
        assertEquals(CompassDirection.N, rover.getCurrentPosition().getFacing());
    }
    // Test cases for position (maxX,maxY) in all directions
    @Test
    @DisplayName("Return current position for start-position maxX,maxY,N")
    void test_move_atMaxXMaxY_facingNorth() {
        pos = new Position(maxX,maxY, CompassDirection.N);
        rover = new Rover(plateau, pos, instructions);
        rover.runInstruction();
        assertEquals(maxX, rover.getCurrentPosition().getX());
        assertEquals(maxY-1, rover.getCurrentPosition().getY());
        assertEquals(CompassDirection.W, rover.getCurrentPosition().getFacing());
    }
    @Test
    @DisplayName("Return current position for start-position maxX,maxY,S")
    void test_move_atMaxXMaxY_facingSouth() {
        pos = new Position(maxX,maxY, CompassDirection.S);
        rover = new Rover(plateau, pos, instructions);
        rover.runInstruction();
        assertEquals(maxX, rover.getCurrentPosition().getX());
        assertEquals(maxY-1, rover.getCurrentPosition().getY());
        assertEquals(CompassDirection.W, rover.getCurrentPosition().getFacing());

    }
    @Test
    @DisplayName("Return current position for start-position maxX,maxY,E")
    void test_move_atMaxXMaxY_facingEast() {
        pos = new Position(maxX,maxY, CompassDirection.E);
        rover = new Rover(plateau, pos, instructions);
        rover.runInstruction();
        assertEquals(maxX-1, rover.getCurrentPosition().getX());
        assertEquals(maxY, rover.getCurrentPosition().getY());
        assertEquals(CompassDirection.N, rover.getCurrentPosition().getFacing());

    }
    @Test
    @DisplayName("Return current position for start-position maxX,maxY,W")
    void test_move_atMaxXMaxY_facingWest() {
        pos = new Position(maxX,maxY, CompassDirection.W);
        rover = new Rover(plateau, pos, instructions);
        rover.runInstruction();
        assertEquals(maxX-1, rover.getCurrentPosition().getX());
        assertEquals(maxY, rover.getCurrentPosition().getY());
        assertEquals(CompassDirection.N, rover.getCurrentPosition().getFacing());
    }
    //Test  cases for position 1,0 in all directions
    @Test
    @DisplayName("Return current position for start-position 1,0,N")
    void test_move_atOneZeroNorth() {
        pos = new Position(1, 0, CompassDirection.N);
        rover = new Rover(plateau, pos, instructions);
        rover.runInstruction();
        assertEquals(1, rover.getCurrentPosition().getX());
        assertEquals(1, rover.getCurrentPosition().getY());
        assertEquals(CompassDirection.E, rover.getCurrentPosition().getFacing());
    }
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
    @DisplayName("Return current position for start-position 1,0,E")
    void test_move_atOneZeroEast() {
        pos = new Position(1, 0, CompassDirection.E);
        rover = new Rover(plateau, pos, instructions);
        rover.runInstruction();
        assertEquals(0, rover.getCurrentPosition().getX());
        assertEquals(0, rover.getCurrentPosition().getY());
        assertEquals(CompassDirection.N, rover.getCurrentPosition().getFacing());
    }
    @Test
    @DisplayName("Return current position for start-position 1,0,W")
    void test_move_atOneZeroWest() {
        pos = new Position(1, 0, CompassDirection.W);
        rover = new Rover(plateau, pos, instructions);
        rover.runInstruction();
        assertEquals(2, rover.getCurrentPosition().getX());
        assertEquals(0, rover.getCurrentPosition().getY());
        assertEquals(CompassDirection.S, rover.getCurrentPosition().getFacing());
    }
    //Test  cases for position 0,1 in all directions
    @Test
    @DisplayName("Return current position for start-position 0,1,N")
    void test_move_atZeroOneNorth() {
        pos = new Position(0, 1, CompassDirection.N);
        rover = new Rover(plateau, pos, instructions);
        rover.runInstruction();
        assertEquals(0, rover.getCurrentPosition().getX());
        assertEquals(0, rover.getCurrentPosition().getY());
        assertEquals(CompassDirection.W, rover.getCurrentPosition().getFacing());
    }  @Test
    @DisplayName("Return current position for start-position 0,1,S")
    void test_move_atZeroOneSouth() {
        pos = new Position(0, 1, CompassDirection.S);
        rover = new Rover(plateau, pos, instructions);
        rover.runInstruction();
        assertEquals(0, rover.getCurrentPosition().getX());
        assertEquals(2, rover.getCurrentPosition().getY());
        assertEquals(CompassDirection.E, rover.getCurrentPosition().getFacing());
    }  @Test
    @DisplayName("Return current position for start-position 0,1,E")
    void test_move_atZeroOneEast() {
        pos = new Position(0, 1, CompassDirection.E);
        rover = new Rover(plateau, pos, instructions);
        rover.runInstruction();
        assertEquals(1, rover.getCurrentPosition().getX());
        assertEquals(1, rover.getCurrentPosition().getY());
        assertEquals(CompassDirection.S, rover.getCurrentPosition().getFacing());
    }  @Test
    @DisplayName("Return current position for start-position 0,1,W")
    void test_move_atZeroOneWest() {
        pos = new Position(0, 1, CompassDirection.W);
        rover = new Rover(plateau, pos, instructions);
        rover.runInstruction();
        assertEquals(1, rover.getCurrentPosition().getX());
        assertEquals(1, rover.getCurrentPosition().getY());
        assertEquals(CompassDirection.S, rover.getCurrentPosition().getFacing());
    }
    //Test  cases for position 1,maxY in all directions
    @Test
    @DisplayName("Return current position for start-position 1,maxY,N")
    void test_move_atOneMaxYNorth() {
        pos = new Position(1,maxY, CompassDirection.N);
        rover = new Rover(plateau, pos, instructions);
        rover.runInstruction();
        assertEquals(1, rover.getCurrentPosition().getX());
        assertEquals(maxY-1, rover.getCurrentPosition().getY());
        assertEquals(CompassDirection.W, rover.getCurrentPosition().getFacing());
    }  @Test
    @DisplayName("Return current position for start-position1,maxY,S")
    void test_move_atOneMaxYSouth() {
        pos = new Position(1,maxY, CompassDirection.S);
        rover = new Rover(plateau, pos, instructions);
        rover.runInstruction();
        assertEquals(1, rover.getCurrentPosition().getX());
        assertEquals(maxY-1, rover.getCurrentPosition().getY());
        assertEquals(CompassDirection.W, rover.getCurrentPosition().getFacing());
    }  @Test
    @DisplayName("Return current position for start-position 1,maxY,E")
    void test_move_atOneMaxYEast() {
        pos = new Position(1,maxY, CompassDirection.E);
        rover = new Rover(plateau, pos, instructions);
        rover.runInstruction();
        assertEquals(0, rover.getCurrentPosition().getX());
        assertEquals(maxY, rover.getCurrentPosition().getY());
        assertEquals(CompassDirection.N, rover.getCurrentPosition().getFacing());
    }  @Test
    @DisplayName("Return current position for start-position 1,maxY,W")
    void test_move_atOneMaxYWest() {
        pos = new Position(1,maxY, CompassDirection.W);
        rover = new Rover(plateau, pos, instructions);
        rover.runInstruction();
        assertEquals(2, rover.getCurrentPosition().getX());
        assertEquals(maxY, rover.getCurrentPosition().getY());
        assertEquals(CompassDirection.S, rover.getCurrentPosition().getFacing());
    }
}