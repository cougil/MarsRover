package com.cougil;

public enum Direction {
    NORTH(0), EAST(1), SOUTH(2), WEST(3);

    private final int value;

    private Direction(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    /**
     * Return that will be the next Direction following the {@link com.cougil.Instruction} specified.
     * It returns the same Direction in case the instruction is not LEFT or RIGHT: because we don't know where to
     * look for, we will continue looking to the same Direction we were previously
     * @param instruction The instruction to follow
     * @return the next Direction that you will get following the instruction specified
     */
    public Direction turn(Instruction instruction) {
        final int directions = Direction.values().length;
        int newPosition = this.getValue();
        if ( Instruction.LEFT.equals(instruction) || (Instruction.RIGHT.equals(instruction)) ) {
            if (Instruction.LEFT.equals(instruction)) {
                newPosition = (this.value - 1) % directions;
                if (newPosition<0) newPosition = directions-1;
            } else {
                newPosition = (this.value + 1) % directions;
            }
        }
        return valueOf(newPosition);
    }

    /**
     * Returns the Direction that has the same value specified or null in other case
     * @param value The value to look for a Direction
     * @return the Direction found or null
     */
    public static Direction valueOf(int value) {
        Direction direction = null;
        Direction[] directions = values();
        for(int i=0;i<directions.length && direction == null; i++) {
            if (directions[i].getValue() == value) {
                direction = directions[i];
            }
        }
        return direction;
    }

}
