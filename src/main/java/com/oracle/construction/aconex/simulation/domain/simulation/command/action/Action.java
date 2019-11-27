package com.oracle.construction.aconex.simulation.domain.simulation.command.action;

import com.oracle.construction.aconex.simulation.exception.SimulationException;
import com.oracle.construction.aconex.simulation.domain.simulation.Context;

public interface Action {
    void execute(Context context) throws SimulationException;
}
