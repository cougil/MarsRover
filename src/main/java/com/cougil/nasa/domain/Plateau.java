package com.cougil.nasa.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Plateau where the robots will land
 */
public final class Plateau {
    private final int maximumX;
    private final int maximumY;
    private final List<MarsRover> marsRovers;

    public Plateau(int maximumX, int maximumY) {
        this.maximumX = maximumX;
        this.maximumY = maximumY;
        this.marsRovers = new ArrayList<>();
    }

    public int getMaximumX() {
        return maximumX;
    }

    public int getMaximumY() {
        return maximumY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Plateau plateau = (Plateau) o;

        if (maximumX != plateau.maximumX) return false;
        if (maximumY != plateau.maximumY) return false;

        return true;
    }

    /**
     * Adds another Mars Rover to the list that has all the plateau robots that have landed
     * @param marsRover The robot that has landed
     */
    public void addMarsRover(MarsRover marsRover) {
        this.marsRovers.add(marsRover);
    }

    /**
     * Checks if exists another Mars Rover that it is located in the same coordinates specified
     * @param coordinates Coordinates to check
     * @return if a Mars Rover is the same coordinates
     */
    public boolean existsMarsRover(Coordinates coordinates) {
        boolean exists = false;
        for (MarsRover anotherMarsRover: marsRovers) {
            exists = (anotherMarsRover.getCoordinates().equals(coordinates));
            if (exists) return exists;
        }
        return exists;
    }
}
