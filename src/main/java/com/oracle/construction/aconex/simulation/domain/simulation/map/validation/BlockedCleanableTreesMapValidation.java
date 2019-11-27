package com.oracle.construction.aconex.simulation.domain.simulation.map.validation;

import com.oracle.construction.aconex.simulation.domain.simulation.map.block.Block;
import com.oracle.construction.aconex.simulation.domain.simulation.map.block.BlockType;
import com.oracle.construction.aconex.simulation.exception.map.UnreachableCleanableBlocksMapSimulationException;

import java.util.List;
import java.util.stream.Collectors;

public class BlockedCleanableTreesMapValidation implements MapValidation {
    @Override
    public boolean validate(List<List<Block>> blocks) throws UnreachableCleanableBlocksMapSimulationException {

        List<Block> protectedBlocks = blocks.stream()
                .flatMap(line -> line.stream()
                        .filter(
                                block -> block.getBlockType().equals(BlockType.T)
                        )
                ).collect((Collectors.toList()));


        if (hasAnyUnreachableCleanableBlocks(protectedBlocks, blocks)) {
            throw new UnreachableCleanableBlocksMapSimulationException();
        }
        return true;
    }

    //TODO: Implement validation?
    private boolean hasAnyUnreachableCleanableBlocks(List<Block> protectedBlocks, List<List<Block>> blocks) {
        return false;
    }
}
