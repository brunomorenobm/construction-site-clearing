package com.oracle.construction.aconex.simulation.domain.simulation.command.action;

import com.oracle.construction.aconex.simulation.domain.simulation.Context;
import com.oracle.construction.aconex.simulation.domain.simulation.command.Command;

public class TerminateCommandAction implements CommandAction {

    /**
     * RULE 7 Quit: end the simulation.
     * @param command
     * @param context
     */
    @Override
    public void execute(Command command, Context context) {
        context.setExecutionSuspended(true);
    }
}
