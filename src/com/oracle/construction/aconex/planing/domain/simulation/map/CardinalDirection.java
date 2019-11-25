package com.oracle.construction.aconex.planing.domain.simulation.map;

import com.oracle.construction.aconex.planing.domain.simulation.command.action.advance.*;

public enum CardinalDirection {
    // TODO: Rethink this method Association with a factory
    N("\u2191", 0, new CommandAdvanceActionNorth()), E("\u2192", 1, new CommandAdvanceActionEast()), S("\u2193", 2, new CommandAdvanceActionSouth()), W("\u2190", 3, new CommandAdvanceActionWest());

    private String character;
    private int index;
    private CommandAdvanceAction advanceAction;

    CardinalDirection(String character, int index, CommandAdvanceAction advanceAction) {
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

    public CommandAdvanceAction getAdvanceAction() {
        return advanceAction;
    }
}
