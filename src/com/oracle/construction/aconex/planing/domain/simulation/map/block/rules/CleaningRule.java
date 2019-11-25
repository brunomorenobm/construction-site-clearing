package com.oracle.construction.aconex.planing.domain.simulation.map.block.rules;

import com.oracle.construction.aconex.planing.exception.rules.InterruptSimulationException;
import com.oracle.construction.aconex.planing.domain.Context;

public interface CleaningRule {
    void apply(Context context) throws InterruptSimulationException;
}
