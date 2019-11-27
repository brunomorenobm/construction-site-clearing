package com.oracle.construction.aconex.simulation.domain.simulation.command.action;

import com.oracle.construction.aconex.simulation.domain.simulation.Context;
import com.oracle.construction.aconex.simulation.domain.simulation.map.CardinalDirection;
import com.oracle.construction.aconex.simulation.domain.simulation.command.Command;

import java.util.Arrays;

public class TurnLeftCommandAction implements CommandAction {

    /**
     * RULE 5 Left: turn the bulldozer (on the spot) 90 degrees to the left of the direction it is facing;
     * @param command
     * @param context
     */
    @Override
    public void execute(Command command, Context context) {

        int currentIndex = context.getCardinalDirection().getIndex();

        currentIndex--;

        if (currentIndex < 0) {
            currentIndex = 3;
        }
        final int indexQuery = currentIndex;

        context.setCardinalDirection( Arrays.stream(CardinalDirection.values())
                .filter(e -> e.getIndex() == indexQuery)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(String.format("Unsupported type %s.", indexQuery))));

    }
}
