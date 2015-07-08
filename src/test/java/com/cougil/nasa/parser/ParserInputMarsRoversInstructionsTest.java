package com.cougil.nasa.parser;

import com.cougil.nasa.domain.Coordinates;
import com.cougil.nasa.domain.Direction;
import com.cougil.nasa.domain.MarsRover;
import com.cougil.nasa.domain.Plateau;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class ParserInputMarsRoversInstructionsTest {

    private ParserInputMarsRovers parserInputMarsRovers;
    private Plateau plateau;

    @Before
    public void setUp() {
        this.parserInputMarsRovers = new ParserInputMarsRoversImpl();
        this.plateau = new Plateau(10,10);
    }

    @Test
    public void testPlateauParsedCorrectly() throws IOException {
        String line = "10 10";
        Plateau parsedPlateau = this.parserInputMarsRovers.parsePlateau(line);
        assertEquals(plateau, parsedPlateau);
    }

    @Test
    public void testMarsRoversPositionParsedCorrectly() throws IOException {
        String line = "2 7 E";
        MarsRover parsedMarsRover = this.parserInputMarsRovers.parseMarsRoverPosition(plateau, line);
        assertEquals( new MarsRover(new Coordinates(2,7), Direction.EAST, plateau), parsedMarsRover);
    }

}
