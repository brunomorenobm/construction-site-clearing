package com.oracle.construction.aconex.planing.domain.simulation.command.action;

import com.oracle.construction.aconex.planing.exception.SimulationException;
import com.oracle.construction.aconex.planing.domain.simulation.Context;

public interface Action {
    void execute(Context context) throws SimulationException;
}
