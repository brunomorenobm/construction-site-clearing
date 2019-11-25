package com.oracle.construction.aconex.planing.domain.simulation.map.block;

import com.oracle.construction.aconex.planing.domain.simulation.map.block.rules.CleaningRuleProtectedTreePenalty;

public class BlockProtectedTree extends Block {

    public BlockProtectedTree() {
        super(BlockType.T,
                null,
                null,
                new CleaningRuleProtectedTreePenalty(),
                new CleaningRuleProtectedTreePenalty())
        ;
    }
}
