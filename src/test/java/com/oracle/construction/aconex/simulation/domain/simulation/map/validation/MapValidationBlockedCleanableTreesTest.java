package com.oracle.construction.aconex.simulation.domain.simulation.map.validation;

import com.oracle.construction.aconex.simulation.domain.simulation.map.block.Block;
import com.oracle.construction.aconex.simulation.domain.simulation.map.block.BlockFactory;
import com.oracle.construction.aconex.simulation.domain.simulation.map.block.BlockType;
import com.oracle.construction.aconex.simulation.exception.map.UnreachableCleanableBlocksMapSimulationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class MapValidationBlockedCleanableTreesTest {

    private BlockFactory blockFactory = new BlockFactory();
    private MapValidation mapValidation = new MapValidationBlockedCleanableTrees();

    @Test
    @Disabled
    void validateBlockedCleanableTreedMap() {
        List<List<Block>> blocks = new ArrayList<>();
        blocks.add(Stream.of(blockFactory.createBlock(BlockType.o), blockFactory.createBlock(BlockType.T), blockFactory.createBlock(BlockType.o), blockFactory.createBlock(BlockType.T)).collect(Collectors.toList()));
        blocks.add(Stream.of(blockFactory.createBlock(BlockType.o), blockFactory.createBlock(BlockType.T), blockFactory.createBlock(BlockType.o), blockFactory.createBlock(BlockType.T)).collect(Collectors.toList()));
        blocks.add(Stream.of(blockFactory.createBlock(BlockType.o), blockFactory.createBlock(BlockType.T), blockFactory.createBlock(BlockType.o), blockFactory.createBlock(BlockType.T)).collect(Collectors.toList()));
        blocks.add(Stream.of(blockFactory.createBlock(BlockType.o), blockFactory.createBlock(BlockType.T), blockFactory.createBlock(BlockType.T), blockFactory.createBlock(BlockType.T)).collect(Collectors.toList()));
        blocks.add(Stream.of(blockFactory.createBlock(BlockType.o), blockFactory.createBlock(BlockType.t), blockFactory.createBlock(BlockType.t), blockFactory.createBlock(BlockType.t)).collect(Collectors.toList()));
        Assertions.assertThrows(UnreachableCleanableBlocksMapSimulationException.class, () -> mapValidation.validate(blocks));

    }

    @Test
    void validateRegularMap() {
        List<List<Block>> blocks = new ArrayList<>();
        blocks.add(Stream.of(blockFactory.createBlock(BlockType.o), blockFactory.createBlock(BlockType.t)).collect(Collectors.toList()));
        blocks.add(Stream.of(blockFactory.createBlock(BlockType.o), blockFactory.createBlock(BlockType.t)).collect(Collectors.toList()));
        blocks.add(Stream.of(blockFactory.createBlock(BlockType.o), blockFactory.createBlock(BlockType.T)).collect(Collectors.toList()));

        Assertions.assertDoesNotThrow(() -> mapValidation.validate(blocks));
    }
}