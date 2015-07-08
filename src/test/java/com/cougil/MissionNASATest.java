package com.cougil;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class MissionNASATest {

    private Plateau plateau;
    private MissionNASA missionNASA;

    @Before
    public void setUp() {
        this.missionNASA = new MissionNASA();
        this.plateau = new Plateau(10,10);
    }

    @Test
    public void testPlateauParsedCorrectly() throws IOException {
        String line = "10 10";
        Plateau parsedPlateau = this.missionNASA.parsePlateau(line);
        assertEquals(plateau, parsedPlateau);
    }

    @Test
    public void testMarsRoversPositionParsedCorrectly() throws IOException {
        String line = "2 7 E";
        MarsRover parsedMarsRover = this.missionNASA.parseMarsRoverPosition(plateau, line);
        assertEquals( new MarsRover(new Coordinates(1,7), Direction.EAST, plateau), parsedMarsRover);
    }

    @Test
    public void testExampleShouldBeCorrectOutputForValidInput() throws IOException {
        String input = "5 5\n" +
                       "1 2 N\n" +
                       "LMLMLMLMM\n"+
                       "3 3 E\n"+
                       "MMRMMRMRRM";

        final String expectedOuput = "1 3 N\n" +
                                     "5 1 E";
        String output = this.missionNASA.run(input);
        assertEquals(expectedOuput, output);
    }
}
