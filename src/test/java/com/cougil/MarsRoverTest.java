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
    public void initialPositionShouldBe_0_0_Facing_North() {
        assertEquals( new Coordinates(0,0), marsRover.getCoordinates());
        assertEquals( Direction.NORTH, marsRover.getDirection());
    }
}
