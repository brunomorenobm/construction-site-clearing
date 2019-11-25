package com.oracle.construction.aconex.planing.model.simulation.command.action;

import com.oracle.construction.aconex.planing.exception.SimulationException;
import com.oracle.construction.aconex.planing.exception.rules.InterruptSimulationException;
import com.oracle.construction.aconex.planing.model.Context;
import com.oracle.construction.aconex.planing.model.simulation.command.Command;

public interface CommandAction {
    void execute(Command command, Context context) throws InterruptSimulationException, SimulationException;
}
