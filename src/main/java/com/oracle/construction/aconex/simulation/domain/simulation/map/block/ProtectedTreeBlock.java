package com.oracle.construction.aconex.simulation.domain.simulation.map.block;

import com.oracle.construction.aconex.simulation.domain.simulation.map.block.rules.ProtectedTreePenaltyCleaningRule;

public class ProtectedTreeBlock extends Block {

    public ProtectedTreeBlock() {
        super(BlockType.T,
                null,
                null,
                new ProtectedTreePenaltyCleaningRule(),
                new ProtectedTreePenaltyCleaningRule())
        ;
    }
}
