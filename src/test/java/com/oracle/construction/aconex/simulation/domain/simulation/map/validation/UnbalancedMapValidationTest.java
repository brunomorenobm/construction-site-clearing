package com.oracle.construction.aconex.simulation.domain.simulation.map.validation;

import com.oracle.construction.aconex.simulation.domain.simulation.map.block.Block;
import com.oracle.construction.aconex.simulation.domain.simulation.map.block.BlockFactory;
import com.oracle.construction.aconex.simulation.domain.simulation.map.block.BlockType;
import com.oracle.construction.aconex.simulation.exception.map.UnbalancedMapSimulationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class UnbalancedMapValidationTest {

    private BlockFactory blockFactory = new BlockFactory();
    private  MapValidation mapValidation = new UnbalancedMapValidation();


    @Test
    void validateUnbalancedMap() {
        List<List<Block>> blocks = new ArrayList<>();
        blocks.add(Stream.of(blockFactory.createBlock(BlockType.o), blockFactory.createBlock(BlockType.t)).collect(Collectors.toList()));
        blocks.add(Stream.of(blockFactory.createBlock(BlockType.o), blockFactory.createBlock(BlockType.t)).collect(Collectors.toList()));
        blocks.add(Stream.of(blockFactory.createBlock(BlockType.o)).collect(Collectors.toList()));

        Assertions.assertThrows(UnbalancedMapSimulationException.class, () -> mapValidation.validate(blocks));

    }

    @Test
    void validateBalancedMap() {
        List<List<Block>> blocks = new ArrayList<>();
        blocks.add(Stream.of(blockFactory.createBlock(BlockType.o), blockFactory.createBlock(BlockType.t)).collect(Collectors.toList()));
        blocks.add(Stream.of(blockFactory.createBlock(BlockType.o), blockFactory.createBlock(BlockType.t)).collect(Collectors.toList()));
        blocks.add(Stream.of(blockFactory.createBlock(BlockType.o), blockFactory.createBlock(BlockType.T)).collect(Collectors.toList()));

        Assertions.assertDoesNotThrow(() -> mapValidation.validate(blocks));
    }

}