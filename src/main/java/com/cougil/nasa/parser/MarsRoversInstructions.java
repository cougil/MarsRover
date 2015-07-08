package com.cougil.nasa.parser;

import com.cougil.nasa.domain.MarsRover;

/**
 * Helper class used to link the MarsRover parsed with their Instructions
 */
public class MarsRoversInstructions {
    private MarsRover marsRover;
    private String instructions;

    public MarsRoversInstructions(MarsRover marsRover, String instructions) {
        this.marsRover = marsRover;
        this.instructions = instructions;
    }

    public MarsRover getMarsRover() {
        return marsRover;
    }

    public String getInstructions() {
        return instructions;
    }
}
