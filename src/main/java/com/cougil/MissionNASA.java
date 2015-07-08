package com.cougil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class MissionNASA {

    public String run(String inputMission) throws IOException {
        StringBuilder output = new StringBuilder("");
        try (BufferedReader br = new BufferedReader(new StringReader(inputMission))) {
            int lineNum = 0;
            Plateau plateau = null;
            MarsRover marsRover = null;
            for(String line = br.readLine(); line != null; line = br.readLine()) {
                if (lineNum == 0) {
                    plateau = parsePlateau(line);
                } else if (lineNum % 2 == 1) {
                    marsRover = parseMarsRoverPosition(plateau, line);
                } else if (lineNum % 2 == 0) {
                    marsRover.instructions(line);
                    output = output.append( marsRover );
                    output = output.append("\n");
                }
                lineNum++;
            }
            output = output.delete(output.length()-1,output.length());
        }
        return output.toString();
    }

    protected MarsRover parseMarsRoverPosition(Plateau plateau, String line) {
        MarsRover marsRover;
        int pos = line.indexOf(" ");
        int x = Integer.parseInt(line.substring(0,pos));
        int y = Integer.parseInt(line.substring(pos+1,line.indexOf(" ",pos+1)));
        Direction direction = Direction.valueOfShortName(line.charAt(line.length()-1));
        Coordinates coordinates = new Coordinates(x,y);
        marsRover = new MarsRover(coordinates, direction, plateau);
        return marsRover;
    }

    protected Plateau parsePlateau(String line) {
        Plateau plateau;
        int pos = line.lastIndexOf(" ");
        int maxX = Integer.parseInt(line.substring(0,pos));
        int maxY = Integer.parseInt(line.substring(pos+1,line.length()));
        plateau = new Plateau(maxX, maxY);
        return plateau;
    }

}
