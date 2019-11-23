package com.oracle.construction.aconex.planing.model.map.action;

import com.oracle.construction.aconex.planing.model.SimulationContext;
import com.oracle.construction.aconex.planing.model.map.Command;

public class ActionSaveCommand implements Action {

    @Override
    public void execute(Command command, SimulationContext context) {
        context.addCommand(command);
    }
}
