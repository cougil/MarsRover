package com.cougil.nasa.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class InstructionTest {

    @Test
    public void valueOfShouldReturnAllValidInstructions() {
        Instruction[] instructions = Instruction.values();
        for (Instruction instruction : instructions) {
            Instruction instr = Instruction.valueOf(instruction.getLetter());
            assertEquals(instruction, instr);
        }
    }

    @Test
    public void valueOfShouldReturnNullWithAnInvalidInstruction() {
        Instruction instruction = Instruction.valueOf('x');
        assertNull(instruction);
    }
}
