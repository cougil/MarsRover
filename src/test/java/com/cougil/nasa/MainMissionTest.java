package com.cougil.nasa;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class MainMissionTest {

    private MainMission mainMission;

    @Before
    public void setUp() {
        this.mainMission = new MainMission();
    }

    @Test
    public void exampleInputShouldReturnCorrectOutput() throws IOException {
        String input = "5 5\n" +
                       "1 2 N\n" +
                       "LMLMLMLMM\n"+
                       "3 3 E\n"+
                       "MMRMMRMRRM";

        final String expectedOuput = "1 3 N\n" +
                                     "5 1 E";
        String output = this.mainMission.run(input);
        assertEquals(expectedOuput, output);
    }

    @Test
    public void exampleInputShouldNotLeaveOutsideThePlateauOutput() throws IOException {
        String input = "5 5\n" +
                       "4 5 N\n" +
                       "MM\n"+
                       "4 0 N\n"+
                       "MM";

        final String expectedOuput = "4 5 N\n" +
                                     "4 2 N";
        String output = this.mainMission.run(input);
        assertEquals(expectedOuput, output);
    }

    @Test
    public void inputWithoutRobotsShouldNotThrowAnyException() throws IOException {
        String input = "5 5\n";

        final String expectedOuput = "";
        String output = this.mainMission.run(input);
        assertEquals(expectedOuput, output);
    }

    @Test
    public void invalidInputShouldNotThrowAnyExceptionAndReturnDefaultPositions() throws IOException {
        String input = "5 5\n"+
                       "a a t\n" +
                       "pp\n"+
                       "b b b\n" +
                       "ee\n"+
                       "e e z\n"+
                       "oo";

        final String expectedOuput = "0 0 N\n" +
                                     "0 0 N\n"+
                                     "0 0 N";
        String output = this.mainMission.run(input);
        assertEquals(expectedOuput, output);
    }
}
