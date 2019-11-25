package com.oracle.construction.aconex.planing.domain.simulation.command.action;

import com.oracle.construction.aconex.planing.domain.Context;
import com.oracle.construction.aconex.planing.domain.simulation.command.Command;

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
