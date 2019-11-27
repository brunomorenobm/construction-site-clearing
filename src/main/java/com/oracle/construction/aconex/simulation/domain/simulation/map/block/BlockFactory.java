package com.oracle.construction.aconex.simulation.domain.simulation.map.block;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class BlockFactory {

    private static final Map<BlockType, Supplier<Block>> map = new HashMap<>();


    static {
        map.put(BlockType.o, PlainBlock::new);
        map.put(BlockType.r, RockyBlock::new);
        map.put(BlockType.t, TreeBlock::new);
        map.put(BlockType.T, ProtectedTreeBlock::new);
    }


    public Block createBlock(BlockType blockType) {
        Supplier<Block> block = map.get(blockType);
        if (block != null) {
            return block.get();
        }
        throw new IllegalArgumentException("No such block Type " + block);
    }
}
