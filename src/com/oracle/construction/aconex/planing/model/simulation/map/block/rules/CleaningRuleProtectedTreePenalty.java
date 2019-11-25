package com.oracle.construction.aconex.planing.model.simulation.map.block.rules;

import com.oracle.construction.aconex.planing.exception.rules.ViolateRuleProtectedTreeException;
import com.oracle.construction.aconex.planing.model.Context;
import com.oracle.construction.aconex.planing.model.billing.BillItem;
import com.oracle.construction.aconex.planing.model.billing.Item;
import com.oracle.construction.aconex.planing.model.simulation.map.CardinalDirection;

public class CleaningRuleProtectedTreePenalty implements CleaningRule {
    @Override
    public void apply(Context context) throws ViolateRuleProtectedTreeException {
        context.getBill().addBillItem(new BillItem(Item.PENALTY_PROTECTED_TREE, 1l));

        // RULE 3: The bulldozer will never be blocked (by an unremovable tree) from entering the site by driving east.
        if (!context.getCardinalDirection().equals(CardinalDirection.E)){
            throw new ViolateRuleProtectedTreeException("You have pass through a block with a protected Tree");
        }

    }
}
