package com.oracle.construction.aconex.planing.model.simulation.map.block.rules;

import com.oracle.construction.aconex.planing.exception.rules.InterruptSimulationException;
import com.oracle.construction.aconex.planing.model.Context;

public interface CleaningRule {
    void apply(Context context) throws InterruptSimulationException;
}
