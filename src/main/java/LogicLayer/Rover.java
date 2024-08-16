package LogicLayer;

import InputLayer.Instruction;
import InputLayer.Position;

import java.util.Queue;

public class Rover {
    private final Position startPosition;
    private Position currentPosition;
    private Queue<Instruction> instructions;

    public Rover(Position startPosition,Queue<Instruction> instructions) {
        this.startPosition = startPosition;
        this.currentPosition = startPosition;
        this.instructions = instructions;
    }

    public void move(){

    }
    public void rotate(){

    }

}
