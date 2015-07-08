package com.cougil.nasa.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MarsRoverTest {

    private MarsRover marsRover;

    @Before
    public void setUp() {
        this.marsRover = new MarsRover();
    }

    @Test
    public void initialPositionShouldNotBeNull() {
        assertNotNull(marsRover.getCoordinates());
    }

    @Test
    public void initialPositionShouldBe_0_0_Facing_North_Plateau_10x10() {
        assertEquals(new Coordinates(0, 0), marsRover.getCoordinates());
        assertEquals(Direction.NORTH, marsRover.getDirection());
        assertEquals(new Plateau(10, 10), marsRover.getPlateau());
    }

    @Test
    public void moveForwardShouldMove1PositionUpperFacingNorth() {
        marsRover = new MarsRover( new Coordinates(5,5), Direction.NORTH, new Plateau(10,10));
        marsRover.instructions("M");
        assertEquals(new Coordinates(5, 6), marsRover.getCoordinates());
        assertEquals(Direction.NORTH, marsRover.getDirection());
    }

    @Test
    public void moveForwardShouldMove1PositionDownFacingSouth() {
        marsRover = new MarsRover( new Coordinates(5,5), Direction.SOUTH, new Plateau(10,10));
        marsRover.instructions("M");
        assertEquals(new Coordinates(5, 4), marsRover.getCoordinates());
        assertEquals(Direction.SOUTH, marsRover.getDirection());
    }

    @Test
    public void moveForwardShouldMove1PositionLeftFacingWest() {
        marsRover = new MarsRover( new Coordinates(5,5), Direction.WEST, new Plateau(10,10));
        marsRover.instructions("M");
        assertEquals(new Coordinates(4, 5), marsRover.getCoordinates());
        assertEquals(Direction.WEST, marsRover.getDirection());
    }

    @Test
    public void moveForwardShouldMove1PositionDownFacingEast() {
        marsRover = new MarsRover( new Coordinates(5,5), Direction.EAST, new Plateau(10,10));
        marsRover.instructions("M");
        assertEquals(new Coordinates(6, 5), marsRover.getCoordinates());
        assertEquals(Direction.EAST, marsRover.getDirection());
    }

    @Test
    public void turnLeftShouldOrientateWestWithoutMovingThePosition() {
        marsRover.instructions("L");
        assertEquals(new Coordinates(0, 0), marsRover.getCoordinates());
        assertEquals(Direction.WEST, marsRover.getDirection());
    }

    @Test
    public void turnRightShouldOrientateEastWithoutMovingThePosition() {
        marsRover.instructions("R");
        assertEquals(new Coordinates(0, 0), marsRover.getCoordinates());
        assertEquals(Direction.EAST, marsRover.getDirection());
    }

    @Test
    public void singleInstructionShouldWorkIgnoringCase() {
        marsRover.instructions("r");
        assertEquals(new Coordinates(0, 0), marsRover.getCoordinates());
        assertEquals(Direction.EAST, marsRover.getDirection());
    }

    @Test
    public void multipleInstructionsShouldWorkIgnoringCase() {
        marsRover.instructions("mr");
        assertEquals(new Coordinates(0, 1), marsRover.getCoordinates());
        assertEquals(Direction.EAST, marsRover.getDirection());
    }


}
