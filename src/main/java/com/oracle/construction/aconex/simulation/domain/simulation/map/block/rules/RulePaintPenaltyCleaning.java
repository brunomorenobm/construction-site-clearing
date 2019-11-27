package com.oracle.construction.aconex.simulation.domain.simulation.map.block.rules;

import com.oracle.construction.aconex.simulation.domain.simulation.Context;
import com.oracle.construction.aconex.simulation.domain.simulation.billing.BillItem;
import com.oracle.construction.aconex.simulation.domain.simulation.billing.Item;
import com.oracle.construction.aconex.simulation.exception.SimulationException;

public class RulePaintPenaltyCleaning implements CleaningRule {
    @Override
    public void apply(Context context) throws SimulationException {
        context.getBill().addBillItem(new BillItem(Item.PENALTY_PAINT, 1l));
    }
}
