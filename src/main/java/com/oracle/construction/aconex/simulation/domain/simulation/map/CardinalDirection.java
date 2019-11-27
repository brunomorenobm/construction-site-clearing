package com.oracle.construction.aconex.simulation.domain.simulation.map;

import com.oracle.construction.aconex.simulation.domain.simulation.command.action.advance.*;

public enum CardinalDirection {
    N("\u2191", 0, new NorthCommandActionAdvance()), E("\u2192", 1, new EastCommandActionAdvance()), S("\u2193", 2, new SouthCommandActionAdvance()), W("\u2190", 3, new WestCommandActionAdvance());

    private String character;
    private int index;
    private CommandActionAdvance advanceAction;

    CardinalDirection(String character, int index, CommandActionAdvance advanceAction) {
        this.character = character;
        this.index = index;
        this.advanceAction = advanceAction;
    }

    public String getCharacter() {
        return character;
    }

    public int getIndex() {
        return index;
    }

    public CommandActionAdvance getAdvanceAction() {
        return advanceAction;
    }
}
