package com.oracle.construction.aconex.planing.model.simulation.map.block;

import com.oracle.construction.aconex.planing.model.simulation.map.Coordinate;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class BlockFactory {

    private static final Map<BlockType, Supplier<Block>> map = new HashMap<>();


    static {
        map.put(BlockType.o, BlockPlain::new);
        map.put(BlockType.r, BlockRocky::new);
        map.put(BlockType.t, BlockTree::new);
        map.put(BlockType.T, BlockProtectedTree::new);
    }


    public Block createBlock(BlockType blockType) {
        Supplier<Block> block = map.get(blockType);
        if (block != null) {
            return block.get();
        }
        throw new IllegalArgumentException("No such block Type " + block);
    }
}
