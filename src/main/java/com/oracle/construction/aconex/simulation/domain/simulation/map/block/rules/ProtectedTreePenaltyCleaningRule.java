package com.oracle.construction.aconex.simulation.domain.simulation.map.block.rules;

import com.oracle.construction.aconex.simulation.domain.simulation.billing.BillItem;
import com.oracle.construction.aconex.simulation.domain.simulation.billing.Item;
import com.oracle.construction.aconex.simulation.domain.simulation.Context;
import com.oracle.construction.aconex.simulation.domain.simulation.map.CardinalDirection;
import com.oracle.construction.aconex.simulation.domain.simulation.map.Coordinate;
import com.oracle.construction.aconex.simulation.exception.SimulationException;
import com.oracle.construction.aconex.simulation.exception.rules.ViolateRuleProtectedTreeException;

public class ProtectedTreePenaltyCleaningRule implements CleaningRule {
    @Override
    public void apply(Context context) throws ViolateRuleProtectedTreeException, SimulationException {
        context.getBill().addBillItem(new BillItem(Item.PENALTY_PROTECTED_TREE, 1l));

        // RULE 3: The bulldozer will never be blocked (by an unremovable tree) from entering the site by driving east.
        if (!(context.getCurrentPosition().equals(new Coordinate(0,0)) && context.getCardinalDirection().equals(CardinalDirection.E))) {
            throw new ViolateRuleProtectedTreeException("You have pass through a block with a protected Tree");
        }
    }
}
