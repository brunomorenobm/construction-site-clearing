package com.oracle.construction.aconex.simulation.domain.simulation.command.action;

import com.oracle.construction.aconex.simulation.domain.simulation.Context;
import com.oracle.construction.aconex.simulation.domain.simulation.command.Command;

public class SaveCommandCommandAction implements CommandAction {

    @Override
    public void execute(Command command, Context context) {
        context.addCommand(command);
    }
}
