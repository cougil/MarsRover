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
}
