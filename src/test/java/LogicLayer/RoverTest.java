package LogicLayer;

import InputLayer.CompassDirection;
import InputLayer.Instruction;
import InputLayer.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class RoverTest {
    Rover rover;
    Position pos ;
    Queue<Instruction> instructions = new LinkedList<>();
    @BeforeEach
    void setUp() {

        instructions.add(Instruction.L);
        instructions.add(Instruction.L);
        instructions.add(Instruction.M);
        instructions.add(Instruction.R);

    }

    @Test
    void test_move() {
        pos = new Position(0,0, CompassDirection.N);
        rover = new Rover(pos,instructions);
        System.out.println("before\n" + rover.getCurrentPosition().getX());
        System.out.println(rover.getCurrentPosition().getY());
        System.out.println(rover.getCurrentPosition().getFacing());
        rover.move();
        System.out.println("After\n" + rover.getCurrentPosition().getX());
        System.out.println(rover.getCurrentPosition().getY());
        System.out.println(rover.getCurrentPosition().getFacing());
//        assertEquals(0,rover.getCurrentPosition().getX());
//        assertEquals(1,rover.getCurrentPosition().getY());

    }
    @Test
    @DisplayName("Return positive value for position 0,0,N")
    void test_move_atZeroZero_facingNorth() {
        pos = new Position(0,0, CompassDirection.N);
        rover = new Rover(pos,instructions);
        rover.move();
        assertEquals(0,rover.getCurrentPosition().getX());
        assertEquals(1,rover.getCurrentPosition().getY());

    }
    @Test
    @DisplayName("Return positive value for position 0,0,E")
    void test_move_atZeroZero_facingEast() {
        pos = new Position(0,0, CompassDirection.E);
        rover = new Rover(pos,instructions);
        rover.move();
        assertEquals(1,rover.getCurrentPosition().getX());
        assertEquals(0,rover.getCurrentPosition().getY());

    }
    @Test
    @DisplayName("Return current position for position 0,0,S")
    void test_move_atZeroZero_facingSouth() {
        pos = new Position(0,0, CompassDirection.S);
        rover = new Rover(pos,instructions);
        rover.move();
        assertEquals(0,rover.getCurrentPosition().getX());
        assertEquals(0,rover.getCurrentPosition().getY());

    }
    @Test
    @DisplayName("Return current position for position 0,0,W")
    void test_move_atZeroZero_facingWest() {
        pos = new Position(0,0, CompassDirection.W);
        rover = new Rover(pos,instructions);
        rover.move();
        assertEquals(0, rover.getCurrentPosition().getX());
        assertEquals(0, rover.getCurrentPosition().getY());
    }
    @Test
    @DisplayName("Return current position for position 1,0,S")
    void test_move_atOneZeroSouth() {
        pos = new Position(1,0, CompassDirection.S);
        rover = new Rover(pos,instructions);
        rover.move();
        assertEquals(1, rover.getCurrentPosition().getX());
        assertEquals(0, rover.getCurrentPosition().getY());
    }
    @Test
    @DisplayName("Return current position for position 0,1,W")
    void test_move_atZeroOneWest() {
        pos = new Position(0,1, CompassDirection.W);
        rover = new Rover(pos,instructions);
        rover.move();
        assertEquals(0, rover.getCurrentPosition().getX());
        assertEquals(1, rover.getCurrentPosition().getY());
    }

        @Test
    void test_rotate() {

        rover.rotate(Instruction.L);
        assertEquals(CompassDirection.N,rover.getCurrentPosition().getFacing());

    }
}