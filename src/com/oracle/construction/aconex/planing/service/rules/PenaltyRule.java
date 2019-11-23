package com.oracle.construction.aconex.planing.service.rules;

import com.oracle.construction.aconex.planing.model.SimulationContext;

public interface PenaltyRule {
    int apply(SimulationContext context);

    void postAction() throws Exception;
}
