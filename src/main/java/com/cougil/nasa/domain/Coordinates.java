package com.cougil.nasa.domain;

/**
 * Represents a position in the plateau of any robotic rover
 */
public class Coordinates {
    private int x;
    private int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinates that = (Coordinates) o;

        if (x != that.x) return false;
        if (y != that.y) return false;

        return true;
    }

    public void move(Direction direction) {
        switch (direction) {
            case NORTH:
                this.y++;
                break;
            case SOUTH:
                this.y--;
                break;
            case EAST:
                this.x++;
                break;
            case WEST:
                this.x--;
                break;
        }
    }
}
