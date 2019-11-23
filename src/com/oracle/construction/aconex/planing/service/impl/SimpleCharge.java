package com.oracle.construction.aconex.planing.service.impl;

import com.oracle.construction.aconex.planing.model.SimulationContext;
import com.oracle.construction.aconex.planing.service.rules.ConsumeRule;

public class SimpleCharge implements ConsumeRule {

    @Override
    public int apply(SimulationContext context) {
        return 1;
    }
}
