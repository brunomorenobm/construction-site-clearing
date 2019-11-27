package com.oracle.construction.aconex.simulation.domain.simulation.command.action;

import com.oracle.construction.aconex.simulation.domain.simulation.Context;
import com.oracle.construction.aconex.simulation.domain.simulation.map.CardinalDirection;
import com.oracle.construction.aconex.simulation.domain.simulation.command.Command;

import java.util.Arrays;

public class TurnRightCommandAction implements CommandAction {

    /**
     * RULE 6 Right: turn the bulldozer 90 degrees to the right;
     * @param command
     * @param context
     */
    @Override
    public void execute(Command command, Context context) {

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
