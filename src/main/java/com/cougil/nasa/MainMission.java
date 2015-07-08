package com.cougil.nasa;

import com.cougil.nasa.domain.MarsRover;
import com.cougil.nasa.parser.MarsRoversInstructions;
import com.cougil.nasa.parser.ParserInputMarsRovers;
import com.cougil.nasa.parser.ParserInputMarsRoversImpl;

import java.io.IOException;
import java.util.List;

/**
 * Main class of the solution: waits for the inputs to process and returns the result
 */
public class MainMission {

    private ParserInputMarsRovers parserInputMarsRovers;

    public MainMission() {
        parserInputMarsRovers = new ParserInputMarsRoversImpl();
    }

    /**
     * Main method responsible of processing the instructions and move all the robotic rovers
     * @param inputMission The commands to process the movements of all the rovers
     * @return The result of moving the rovers
     */
    public String run(String inputMission) {
        StringBuilder output = new StringBuilder("");
        try {
            List<MarsRoversInstructions> marsRoverInstructionsList  = this.parserInputMarsRovers.parse(inputMission);

            for (MarsRoversInstructions marsRoverInstructions : marsRoverInstructionsList) {
                MarsRover marsRover = marsRoverInstructions.getMarsRover();
                marsRover.instructions(marsRoverInstructions.getInstructions());

                output = output.append( marsRover );
                output = output.append("\n");
            }
            output = output.delete(output.length()-1,output.length());

        } catch (IOException e) {
            // TODO - should log an error or throw the exception
            e.printStackTrace();
        }

        return output.toString();

    }

}
