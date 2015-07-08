package com.cougil.nasa.parser;

import com.cougil.nasa.domain.Coordinates;
import com.cougil.nasa.domain.Direction;
import com.cougil.nasa.domain.MarsRover;
import com.cougil.nasa.domain.Plateau;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Parser responsible of processing the instructions and information of all the Mars Rovers
 */
public class ParserInputMarsRoversImpl implements ParserInputMarsRovers {

    private List<MarsRoversInstructions> marsRoversInstructions;

    @Override
    public List<MarsRoversInstructions> parse(String input) throws IOException {
        marsRoversInstructions = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new StringReader(input))) {
            int lineNum = 0;
            Plateau plateau = null;
            MarsRover marsRover = null;
            for(String line = br.readLine(); line != null; line = br.readLine()) {
                if (lineNum == 0) {
                    plateau = parsePlateau(line);
                } else if (lineNum % 2 == 1) {
                    marsRover = parseMarsRoverPosition(plateau, line);
                } else if (lineNum % 2 == 0) {
                    marsRoversInstructions.add( new MarsRoversInstructions( marsRover, line ));
                }
                lineNum++;
            }
        }

        return marsRoversInstructions;
    }

    @Override
    public MarsRover parseMarsRoverPosition(Plateau plateau, String line) {
        MarsRover marsRover;
        int pos = line.indexOf(" ");
        int x = Integer.parseInt(line.substring(0,pos));
        int y = Integer.parseInt(line.substring(pos+1,line.indexOf(" ",pos+1)));
        Direction direction = Direction.valueOfShortName(line.charAt(line.length()-1));
        Coordinates coordinates = new Coordinates(x,y);
        marsRover = new MarsRover(coordinates, direction, plateau);
        return marsRover;
    }

    @Override
    public Plateau parsePlateau(String line) {
        Plateau plateau;
        int pos = line.lastIndexOf(" ");
        int maxX = Integer.parseInt(line.substring(0,pos));
        int maxY = Integer.parseInt(line.substring(pos+1,line.length()));
        plateau = new Plateau(maxX, maxY);
        return plateau;
    }

}
