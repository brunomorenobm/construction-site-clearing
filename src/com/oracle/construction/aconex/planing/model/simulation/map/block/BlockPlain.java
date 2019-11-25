package com.oracle.construction.aconex.planing.model.simulation.map.block;

import com.oracle.construction.aconex.planing.model.simulation.map.block.rules.CleaningRuleOneFuelConsumption;

public class BlockPlain extends Block {

    public BlockPlain() {
        super(  BlockType.o,
                new CleaningRuleOneFuelConsumption(),
                new CleaningRuleOneFuelConsumption(),
                null,
                null);
    }
}
