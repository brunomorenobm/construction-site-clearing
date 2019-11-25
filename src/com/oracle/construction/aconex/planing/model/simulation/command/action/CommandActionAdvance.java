package com.oracle.construction.aconex.planing.model.simulation.command.action;

import com.oracle.construction.aconex.planing.exception.command.InvalidCommandException;
import com.oracle.construction.aconex.planing.exception.SimulationException;
import com.oracle.construction.aconex.planing.exception.rules.InterruptSimulationException;
import com.oracle.construction.aconex.planing.model.Context;
import com.oracle.construction.aconex.planing.model.simulation.command.Command;
import com.oracle.construction.aconex.planing.model.simulation.map.CardinalDirection;

public class CommandActionAdvance implements CommandAction {

    /**
     * RULE 4 Advance: this command takes a positive integer parameter to define the number of squares the bulldozer should move forwards (in whatever direction it is currently facing);
     *
     * @param command
     * @param context
     * @throws SimulationException
     */
    @Override
    public void execute(Command command, Context context) throws InterruptSimulationException, SimulationException {

        context.getCurrentPosition();
        CardinalDirection facingDirection = context.getCardinalDirection();

        // TODO: Move thi validation to command parse
        int blocksToMove;
        try {
            blocksToMove = Integer.valueOf(command.getAttribute());
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
            throw new InvalidCommandException(command.getInputCommand(), command.getAttribute());
        }


        try {
            facingDirection.getAdvanceAction().execute(blocksToMove, context);
        } catch (InterruptSimulationException ex) {
            ex.printStackTrace(System.err);
            context.setExecutionSuspended(true);
            throw ex;
        } catch (SimulationException ex) {
            ex.printStackTrace(System.err);
            context.setExecutionSuspended(true);
        }
    }
}
