package com.oracle.construction.aconex.planing.domain.simulation.map.block;

import com.oracle.construction.aconex.planing.domain.simulation.map.block.rules.CleaningRuleDoubleFuelConsumption;
import com.oracle.construction.aconex.planing.domain.simulation.map.block.rules.CleaningRuleOneFuelConsumption;

public class BlockRocky extends Block {

    public BlockRocky() {
        super(BlockType.r,
                new CleaningRuleDoubleFuelConsumption(),
                new CleaningRuleOneFuelConsumption(),
                null,
                null)
        ;
    }
}
