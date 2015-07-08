package com.cougil;

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
        assertEquals( new Coordinates(0,0), marsRover.getCoordinates());
        assertEquals( Direction.NORTH, marsRover.getDirection());
        assertEquals( new Plateau(10,10), marsRover.getPlateau() );
    }

    @Test
    public void moveForwardShouldMove1PositionUpper() {
        marsRover.instructions("M");
        assertEquals(new Coordinates(0,1), marsRover.getCoordinates());
        assertEquals( Direction.NORTH, marsRover.getDirection());
    }

    @Test
    public void turnLeftShouldOrientateWestWithoutMovingThePosition() {
        marsRover.instructions("L");
        assertEquals(new Coordinates(0,0), marsRover.getCoordinates());
        assertEquals( Direction.WEST, marsRover.getDirection());
    }

    @Test
    public void turnRightShouldOrientateEastWithoutMovingThePosition() {
        marsRover.instructions("R");
        assertEquals(new Coordinates(0,0), marsRover.getCoordinates());
        assertEquals( Direction.EAST, marsRover.getDirection());
    }

    @Test
    public void singleInstructionShouldWorkIgnoringCase() {
        marsRover.instructions("r");
        assertEquals(new Coordinates(0,0), marsRover.getCoordinates());
        assertEquals( Direction.EAST, marsRover.getDirection());
    }

    @Test
    public void multipleInstructionsShouldWorkIgnoringCase() {
        marsRover.instructions("mr");
        assertEquals(new Coordinates(0,1), marsRover.getCoordinates());
        assertEquals( Direction.EAST, marsRover.getDirection());
    }


}
