package com.cougil.nasa.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class DirectionTest {

    private Random random;

    @Before
    public void setUp() {
        random = new Random();
    }

    @Test
    public void valueOfShouldReturnAllValidDirections() {
        Direction[] directions = Direction.values();
        for(Direction direction : directions) {
            Direction dir = Direction.valueOf(direction.getValue());
            assertEquals(direction, dir);
        }
    }

    @Test
    public void valueOfShouldReturnNullWithAnInvalidDirection() {
        Direction direction = Direction.valueOf(12);
        assertNull(direction);
    }

    @Test
    public void valueOfShortNameShouldReturnAllValidDirections() {
        Direction[] directions = Direction.values();
        for(Direction direction : directions) {
            Direction dir = Direction.valueOfShortName(direction.getShortName());
            assertEquals(direction, dir);
        }
    }

    @Test
    public void valueOfShortNameShouldReturnNullWithAnInvalidDirection() {
        Direction direction = Direction.valueOfShortName('z');
        assertNull(direction);
    }

    @Test
    public void movingShouldNotChangeThePreviousDirection() {
        int randomInt = random.nextInt(Direction.values().length);
        Direction previousDirection = Direction.values()[randomInt];
        Direction newDirection = previousDirection.turn(Instruction.MOVE);
        assertEquals(previousDirection, newDirection);
    }

    @Test
    public void turningLeftFromNorthShouldReturnWest() {
        Direction direction = Direction.NORTH.turn(Instruction.LEFT);
        assertEquals(direction, Direction.WEST);
    }
    @Test
    public void turningLeftFromWestShouldReturnSouth() {
        Direction direction = Direction.WEST.turn(Instruction.LEFT);
        assertEquals(direction, Direction.SOUTH);
    }
    @Test
    public void turningLeftFromSouthShouldReturnEast() {
        Direction direction = Direction.SOUTH.turn(Instruction.LEFT);
        assertEquals(direction, Direction.EAST);
    }
    @Test
    public void turningLeftFromEastShouldReturnNorth() {
        Direction direction = Direction.EAST.turn(Instruction.LEFT);
        assertEquals(direction, Direction.NORTH);
    }

    @Test
    public void turningRightFromNorthShouldReturnEast() {
        Direction direction = Direction.NORTH.turn(Instruction.RIGHT);
        assertEquals(direction, Direction.EAST);
    }
    @Test
    public void turningRightFromEastShouldReturnSouth() {
        Direction direction = Direction.EAST.turn(Instruction.RIGHT);
        assertEquals(direction, Direction.SOUTH);
    }
    @Test
    public void turningRightFromSouthShouldReturnWest() {
        Direction direction = Direction.SOUTH.turn(Instruction.RIGHT);
        assertEquals(direction, Direction.WEST);
    }
    @Test
    public void turningRightFromWestShouldReturnNorth() {
        Direction direction = Direction.WEST.turn(Instruction.RIGHT);
        assertEquals(direction, Direction.NORTH);
    }
}
