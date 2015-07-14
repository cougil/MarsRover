package com.cougil.nasa.domain;

/**
 * Class that represents a Mars Rovers
 */
public class MarsRover {
    private Coordinates coordinates;
    private Direction direction;
    private Plateau plateau;

    public MarsRover() {
        this(new Coordinates(0,0), Direction.NORTH, new Plateau(10,10));
    }

    public MarsRover(Coordinates coordinates, Direction direction, Plateau plateau) {
        this.coordinates = coordinates;
        this.direction = direction;
        this.plateau = plateau;
        this.plateau.addMarsRover(this);
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

    /**
     * Moves the Mars Rovers, taking care of the instructions: if they are recognized or not, they will make something
     * (changing direction or moving forward) or not. Also, the rover tries to figure out if the coordinate they will
     * want to move there is any other Mars Rovers in there, and in this case it won't move it.
     *
     * @param instructions The instructions to be followed by the Mars Rover
     */
    public void instructions(String instructions) {
        for (char instructionChar: instructions.toCharArray()) {
            Instruction instruction = Instruction.valueOf(instructionChar);
            if (instruction != null) {
                switch (instruction) {
                    case LEFT:
                        this.direction = this.direction.turn(Instruction.LEFT);
                        break;
                    case RIGHT:
                        this.direction = this.direction.turn(Instruction.RIGHT);
                        break;
                    case MOVE:
                        int x = this.getCoordinates().getX();
                        int y = this.getCoordinates().getY();
                        Coordinates newCoordinates = new Coordinates(x,y);
                        newCoordinates = newCoordinates.move(getDirection());
                        newCoordinates = evaluatePlateauCoordinatesLimits(newCoordinates);
                        // we must check that there isn't any other MarsRovers there!
                        if (!this.plateau.existsMarsRover(newCoordinates)) {
                            this.coordinates = newCoordinates;
                        }
                        break;
                }
            }
        }
    }

    private Coordinates evaluatePlateauCoordinatesLimits(Coordinates newCoordinates) {
        int x = newCoordinates.getX();
        int y = newCoordinates.getY();
        if (x > plateau.getMaximumX()) {
            x = 0;
        } else if (x < 0) {
            x = plateau.getMaximumX();
        }
        if (y > plateau.getMaximumY()) {
            y = 0;
        } else if (y < 0) {
            y = plateau.getMaximumY();
        }
        return new Coordinates(x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MarsRover marsRover = (MarsRover) o;

        if (coordinates != null ? !coordinates.equals(marsRover.coordinates) : marsRover.coordinates != null)
            return false;
        if (direction != marsRover.direction) return false;
        if (plateau != null ? !plateau.equals(marsRover.plateau) : marsRover.plateau != null) return false;

        return true;
    }

    @Override
    public String toString() {
        return new StringBuilder("")
                .append(coordinates.getX())
                .append(" ")
                .append(coordinates.getY())
                .append(" ")
                .append(direction.getShortName())
            .toString();
    }

}
