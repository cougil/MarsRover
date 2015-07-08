package com.cougil;

public class MarsRover {
    private Coordinates coordinates;
    private Direction direction;

    public MarsRover() {
        this.coordinates = new Coordinates(0,0);
        this.direction = Direction.NORTH;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Direction getDirection() {
        return direction;
    }

    public void instructions(String instructions) {
        for (char instructionChar: instructions.toCharArray()) {
            Instruction instruction = Instruction.valueOf(instructionChar);
            switch (instruction) {
                case LEFT:
                    this.direction = this.direction.turn(Instruction.LEFT);
                    break;
                case RIGHT:
                    this.direction = this.direction.turn(Instruction.RIGHT);
                    break;
                case MOVE:
                        this.getCoordinates().move(getDirection());
                    break;
                default:
                    break;
            }
        }
    }
}
