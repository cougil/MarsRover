package com.cougil.nasa.domain;

/**
 * Plateau where the robots will land
 */
public class Plateau {
    private final int maximumX;
    private final int maximumY;

    public Plateau(int maximumX, int maximumY) {
        this.maximumX = maximumX;
        this.maximumY = maximumY;
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

}
