package com.oracle.construction.aconex.planing.model.map.action;

import com.oracle.construction.aconex.planing.model.CardinalDirection;
import com.oracle.construction.aconex.planing.model.SimulationContext;
import com.oracle.construction.aconex.planing.model.map.Command;

import java.util.Arrays;

public class ActionTurnRight implements Action {

    @Override
    public void execute(Command command, SimulationContext context) {

        int currentIndex = context.getCardinalDirection().getIndex();

        currentIndex++;

        if (currentIndex > 3) {
            currentIndex = 0;
        }
        final int indexQuery = currentIndex;

        context.setCardinalDirection(Arrays.stream(CardinalDirection.values())
                .filter(e -> e.getIndex() == indexQuery)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(String.format("Unsupported type %s.", indexQuery))));

    }
}
