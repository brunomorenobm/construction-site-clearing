package com.oracle.construction.aconex.simulation.domain.simulation.map.block;

import com.oracle.construction.aconex.simulation.domain.simulation.map.block.rules.DoubleFuelConsumptionCleaningRule;
import com.oracle.construction.aconex.simulation.domain.simulation.map.block.rules.OneFuelConsumptionCleaningRule;

public class RockyBlock extends Block {

    public RockyBlock() {
        super(BlockType.r,
                new DoubleFuelConsumptionCleaningRule(),
                new OneFuelConsumptionCleaningRule(),
                null,
                null)
        ;
    }
}
