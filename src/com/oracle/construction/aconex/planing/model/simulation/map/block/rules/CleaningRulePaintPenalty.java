package com.oracle.construction.aconex.planing.model.simulation.map.block.rules;

import com.oracle.construction.aconex.planing.model.Context;
import com.oracle.construction.aconex.planing.model.billing.BillItem;
import com.oracle.construction.aconex.planing.model.billing.Item;

public class CleaningRulePaintPenalty implements CleaningRule {
    @Override
    public void apply(Context context) {
        context.getBill().addBillItem(new BillItem(Item.PENALTY_PAINT, 1l));
    }
}
