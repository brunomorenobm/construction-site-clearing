package com.oracle.construction.aconex.planing.service.impl;

import com.oracle.construction.aconex.planing.exception.ViolateRuleProtectedTreeException;
import com.oracle.construction.aconex.planing.model.SimulationContext;
import com.oracle.construction.aconex.planing.service.rules.PenaltyRule;

public class ProtectedTreePenalty implements PenaltyRule {
    @Override
    public int apply(SimulationContext context) {
        return 10;
    }

    @Override
    public void postAction() throws Exception {
        throw new ViolateRuleProtectedTreeException("Violated new message");
    }
}
