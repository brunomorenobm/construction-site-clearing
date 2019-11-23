package com.oracle.construction.aconex.planing.model;

import com.oracle.construction.aconex.planing.model.map.action.advance.*;

public enum CardinalDirection {
    N("\u2191", 0, new AdvanceActionNorth()), E("\u2192", 1, new AdvanceActionEast()), S("\u2193", 2, new AdvanceActionSouth()), W("\u2190", 3, new AdvanceActionWest());

    private String character;
    private int index;
    private AdvanceAction advanceAction;

    CardinalDirection(String character, int index, AdvanceAction advanceAction) {
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

    public AdvanceAction getAdvanceAction() {
        return advanceAction;
    }
}
