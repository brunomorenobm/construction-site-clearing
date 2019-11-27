package com.oracle.construction.aconex.simulation.domain.simulation.map.block;

import com.oracle.construction.aconex.simulation.domain.simulation.map.block.rules.DoubleFuelConsumptionCleaningRule;
import com.oracle.construction.aconex.simulation.domain.simulation.map.block.rules.OneFuelConsumptionCleaningRule;
import com.oracle.construction.aconex.simulation.domain.simulation.map.block.rules.RulePaintPenaltyCleaning;

public class TreeBlock extends Block {

    public TreeBlock() {
        super(BlockType.t,
                new DoubleFuelConsumptionCleaningRule(),
                new OneFuelConsumptionCleaningRule(),
                null,
                new RulePaintPenaltyCleaning());
    }
}
