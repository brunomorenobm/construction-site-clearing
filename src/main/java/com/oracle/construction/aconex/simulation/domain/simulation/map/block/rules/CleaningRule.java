package com.oracle.construction.aconex.simulation.domain.simulation.map.block.rules;

import com.oracle.construction.aconex.simulation.exception.SimulationException;
import com.oracle.construction.aconex.simulation.exception.rules.InterruptSimulationException;
import com.oracle.construction.aconex.simulation.domain.simulation.Context;

public interface CleaningRule {
    void apply(Context context) throws InterruptSimulationException, SimulationException;
}
