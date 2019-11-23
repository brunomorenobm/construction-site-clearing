package com.oracle.construction.aconex.planing.model.map.action;

import com.oracle.construction.aconex.planing.model.SimulationContext;
import com.oracle.construction.aconex.planing.model.map.Command;

public interface Action {
    void execute(Command command, SimulationContext context);
}
