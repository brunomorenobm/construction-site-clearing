package com.oracle.construction.aconex.planing.model.simulation.map.validation;

import com.oracle.construction.aconex.planing.exception.rules.InterruptSimulationException;
import com.oracle.construction.aconex.planing.exception.map.UnreachableCleanableBlocksMapSimulationException;
import com.oracle.construction.aconex.planing.model.simulation.map.block.Block;
import com.oracle.construction.aconex.planing.model.simulation.map.block.BlockType;

import java.util.List;
import java.util.stream.Collectors;

public class MapValidationBlockedCleaneableTrees implements MapValidation {
    @Override
    public boolean validate(List<List<Block>> blocks) throws UnreachableCleanableBlocksMapSimulationException{

        List<Block> protectedBlocks = blocks.stream()
                .flatMap(line -> line.stream()
                        .filter(
                                block -> block.getBlockType().equals(BlockType.T)
                        )
                ).collect((Collectors.toList()));


        if (hasAnyUncreachableCleanableBlocks(protectedBlocks, blocks)) {
            throw new UnreachableCleanableBlocksMapSimulationException();
        }
        return true;
    }

    //TODO: Implement validation?
    private boolean hasAnyUncreachableCleanableBlocks(List<Block> protectedBlocks, List<List<Block>> blocks) {
        return false;
    }
}
