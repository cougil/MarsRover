package com.cougil.nasa.domain;

/**
 * Available instructions to deliver to any rover
 */
public enum Instruction {
    LEFT('L'), RIGHT('R'), MOVE('M');

    private final char letter;

    private Instruction(char letter) {
        this.letter = Character.toUpperCase(letter);
    }

    protected char getLetter() {
        return letter;
    }

    public static Instruction valueOf(char c) {
        Instruction instr = null;
        Character character = Character.toUpperCase(c);
        Instruction[] instructions = values();
        for(int i=0;i<instructions.length && instr == null; i++) {
            if (instructions[i].getLetter() == character.charValue()) {
                instr = instructions[i];
            }
        }
        return instr;
    }
}
