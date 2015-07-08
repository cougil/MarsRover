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
}
