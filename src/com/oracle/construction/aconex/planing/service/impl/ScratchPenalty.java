package com.oracle.construction.aconex.planing.service.impl;

import com.oracle.construction.aconex.planing.model.SimulationContext;
import com.oracle.construction.aconex.planing.service.rules.PenaltyRule;

public class ScratchPenalty implements PenaltyRule {
    @Override
    public int apply(SimulationContext context) {
        return 2;
    }

    @Override
    public void postAction() throws RuntimeException {

    }
}
