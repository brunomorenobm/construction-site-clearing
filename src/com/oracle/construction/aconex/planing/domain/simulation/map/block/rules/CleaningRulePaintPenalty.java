package com.oracle.construction.aconex.planing.domain.simulation.map.block.rules;

import com.oracle.construction.aconex.planing.domain.simulation.Context;
import com.oracle.construction.aconex.planing.domain.billing.BillItem;
import com.oracle.construction.aconex.planing.domain.billing.Item;

public class CleaningRulePaintPenalty implements CleaningRule {
    @Override
    public void apply(Context context) {
        context.getBill().addBillItem(new BillItem(Item.PENALTY_PAINT, 1l));
    }
}
