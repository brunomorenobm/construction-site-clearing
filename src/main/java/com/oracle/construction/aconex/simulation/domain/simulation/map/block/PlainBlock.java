package com.oracle.construction.aconex.simulation.domain.simulation.map.block;

import com.oracle.construction.aconex.simulation.domain.simulation.map.block.rules.OneFuelConsumptionCleaningRule;

public class PlainBlock extends Block {

    public PlainBlock() {
        super(  BlockType.o,
                new OneFuelConsumptionCleaningRule(),
                new OneFuelConsumptionCleaningRule(),
                null,
                null);
    }
}
