package com.oracle.construction.aconex.simulation.domain.simulation.map.block;

import org.junit.jupiter.api.Test;

class BlockFactoryTest {

    @Test
    void checkIfAllEnumItemsHasFactory() {
        BlockFactory factory = new BlockFactory();
        for (BlockType blockType : BlockType.values()) {
            factory.createBlock(blockType);
        }
    }
}