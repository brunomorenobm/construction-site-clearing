package com.oracle.construction.aconex.planing.service.rules;

import com.oracle.construction.aconex.planing.model.SimulationContext;

public interface ConsumeRule {
    int apply (SimulationContext context);
}
