package com.oracle.construction.aconex.planing.model.simulation.command.action;

import com.oracle.construction.aconex.planing.model.Context;
import com.oracle.construction.aconex.planing.model.simulation.command.Command;

public class CommandActionTerminate implements CommandAction {

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
