package com.cougil.nasa.parser;

import com.cougil.nasa.domain.MarsRover;
import com.cougil.nasa.domain.Plateau;

import java.io.IOException;
import java.util.List;

/**
 * Interface that provides the main functionality to parse the info from the instructions provided
 */
public interface ParserInputMarsRovers {

    /**
     * Parses the specified input in order to retrieve all the {@link com.cougil.nasa.domain.MarsRover}
     * @param input Input information with all the details for the plateau, rovers, etc:<br>
     *              -The first line of input, the upper-right coordinates of the plateau<br>
     *              -The rest of the input is information pertaining to the rovers that have been deployed.
     *              Each rover has two lines of input. The first line gives the rover’s position, and the second
     *              line is a series of instructions telling the rover how to explore the plateau.
     * @return The element that contains the list of {@link com.cougil.nasa.domain.MarsRover} with their {@link com.cougil.nasa.domain.Instruction} associated
     * @throws IOException In case the input text is not according the specified format
     */
    List<MarsRoversInstructions> parse(String input) throws IOException;

    /**
     * Parses the rovers position and returns its information
     * @param plateau {@link com.cougil.nasa.domain.Plateau} extracted that will be linked to this {@link com.cougil.nasa.domain.MarsRover}
     * @param line String that represents the line with all the information
     * @return Mars Rovers processed
     */
    MarsRover parseMarsRoverPosition(Plateau plateau, String line);

    /**
     * Parses the plateau and returns its information
     * @param line String that represents the line with all the information
     * @return Plateau processed
     */
    Plateau parsePlateau(String line);
}
