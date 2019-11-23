package com.oracle.construction.aconex.planing.model.map.action;

import com.oracle.construction.aconex.planing.model.CardinalDirection;
import com.oracle.construction.aconex.planing.model.SimulationContext;
import com.oracle.construction.aconex.planing.model.map.Command;

public class ActionAdvance implements Action {

    @Override
    public void execute(Command command, SimulationContext context) {

        context.getCurrentPosition();
        CardinalDirection facingDirection = context.getCardinalDirection();
        // TODO: Move the parse int to command
        String attribute = command.getAttribute();
        int blocksToMove = Integer.valueOf(attribute);
        context.getBlocks();
        try {
            facingDirection.getAdvanceAction().execute(blocksToMove, context);
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
            context.setExecutionSuspended(true);
        }
    }
}
