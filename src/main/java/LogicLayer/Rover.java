package LogicLayer;

import InputLayer.CompassDirection;
import InputLayer.Instruction;
import InputLayer.Position;

import java.util.Queue;

public class Rover{
    private final Position startPosition;
    private Position currentPosition;
    private Queue<Instruction> instructions;

    public Rover(Position startPosition,Queue<Instruction> instructions) {
        this.startPosition = startPosition;
        this.currentPosition = startPosition;
        this.instructions = instructions;
        runInstruction();
    }

    private void runInstruction() {
        while(!instructions.isEmpty()){
            Instruction i = instructions.remove();
            if(i == Instruction.L || i == Instruction.R){
                rotate(i);
            } else if (i == Instruction.M) {
              synchronized (this){
                  move();
              };
            }
        }
    }

    public void move(){
        if(!isPositionOutOfBound && isPositionFree) {
            switch (currentPosition.getFacing()) {
                case N -> currentPosition.setY(getCurrentPosition().getY() + 1);
                case E -> currentPosition.setX(getCurrentPosition().getX() + 1);
                case W -> currentPosition.setX(getCurrentPosition().getX() - 1);
                case S -> currentPosition.setY(getCurrentPosition().getY() - 1);
            }
        }

    }
    public void rotate(Instruction instruction){
        if(instruction.equals(Instruction.L)) {
            switch (currentPosition.getFacing()) {
                case N -> currentPosition.setFacing(CompassDirection.W);
                case E -> currentPosition.setFacing(CompassDirection.N);
                case W -> currentPosition.setFacing(CompassDirection.S);
                case S -> currentPosition.setFacing(CompassDirection.E);
            }
        }
            else if(instruction.equals(Instruction.R)) {
            switch (currentPosition.getFacing()) {
                case N -> currentPosition.setFacing(CompassDirection.E);
                case E -> currentPosition.setFacing(CompassDirection.S);
                case W -> currentPosition.setFacing(CompassDirection.N);
                case S -> currentPosition.setFacing(CompassDirection.W);
            }
        }


    }

    public Position getStartPosition() {
        return startPosition;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Queue<Instruction> getInstructions() {
        return instructions;
    }

    public void setInstructions(Queue<Instruction> instructions) {
        this.instructions = instructions;
    }

}
