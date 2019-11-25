package com.oracle.construction.aconex.planing.domain.simulation.map.block.rules;

import com.oracle.construction.aconex.planing.domain.Context;
import com.oracle.construction.aconex.planing.domain.billing.BillItem;
import com.oracle.construction.aconex.planing.domain.billing.Item;

public class CleaningRuleOneFuelConsumption implements CleaningRule {
    @Override
    public void apply(Context context) {
        context.getBill().addBillItem(new BillItem(Item.FUEL, 1l));
    }
}
