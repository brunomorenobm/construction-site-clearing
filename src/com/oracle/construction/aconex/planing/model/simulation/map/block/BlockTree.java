package com.oracle.construction.aconex.planing.model.simulation.map.block;

import com.oracle.construction.aconex.planing.model.simulation.map.block.rules.CleaningRuleDoubleFuelConsumption;
import com.oracle.construction.aconex.planing.model.simulation.map.block.rules.CleaningRuleOneFuelConsumption;
import com.oracle.construction.aconex.planing.model.simulation.map.block.rules.CleaningRulePaintPenalty;

public class BlockTree extends Block {

    public BlockTree() {
        super(BlockType.t,
                new CleaningRuleDoubleFuelConsumption(),
                new CleaningRuleOneFuelConsumption(),
                null,
                new CleaningRulePaintPenalty());
    }
}
