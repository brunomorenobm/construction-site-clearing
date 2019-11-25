package com.oracle.construction.aconex.planing.model.simulation.command.action;

import com.oracle.construction.aconex.planing.model.Context;
import com.oracle.construction.aconex.planing.model.simulation.command.Command;

public class CommandActionSaveCommand implements CommandAction {

    @Override
    public void execute(Command command, Context context) {
        context.addCommand(command);
    }
}
