package com.cougil;

public class MarsRover {
    private Coordinates coordinates;
    private Direction direction;
    private final Plateau plateau;

    public MarsRover() {
        this(new Coordinates(0,0), Direction.NORTH, new Plateau(10,10));
    }

    public MarsRover(Coordinates coordinates, Direction direction, Plateau plateau) {
        this.coordinates = coordinates;
        this.direction = direction;
        this.plateau = plateau;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Direction getDirection() {
        return direction;
    }

    public Plateau getPlateau() {
        return plateau;
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

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder = stringBuilder.append(coordinates.getX());
        stringBuilder = stringBuilder.append(coordinates.getY());
        stringBuilder = stringBuilder.append(direction.getShortName());
        return stringBuilder.toString();
    }

}
