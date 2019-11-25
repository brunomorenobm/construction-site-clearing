package com.oracle.construction.aconex.planing.domain.simulation.command.action;

import com.oracle.construction.aconex.planing.domain.simulation.Context;
import com.oracle.construction.aconex.planing.domain.simulation.command.Command;

public class CommandActionSaveCommand implements CommandAction {

    @Override
    public void execute(Command command, Context context) {
        context.addCommand(command);
    }
}
