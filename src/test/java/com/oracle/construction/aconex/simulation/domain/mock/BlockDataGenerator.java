package com.oracle.construction.aconex.simulation.domain.mock;

import com.oracle.construction.aconex.simulation.domain.simulation.map.Coordinate;
import com.oracle.construction.aconex.simulation.domain.simulation.map.block.Block;
import com.oracle.construction.aconex.simulation.domain.simulation.map.block.BlockFactory;
import com.oracle.construction.aconex.simulation.domain.simulation.map.block.BlockType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BlockDataGenerator {

    public static Optional<List<List<Block>>> simpleBlocks() {
        List<List<Block>> blocks = new ArrayList<>();
        BlockFactory factory = new BlockFactory();
        blocks.add(Stream.of(factory.createBlock(BlockType.t), factory.createBlock(BlockType.t), factory.createBlock(BlockType.t)).collect(Collectors.toList()));
        blocks.add(Stream.of(factory.createBlock(BlockType.t), factory.createBlock(BlockType.t), factory.createBlock(BlockType.t)).collect(Collectors.toList()));
        blocks.add(Stream.of(factory.createBlock(BlockType.t), factory.createBlock(BlockType.t), factory.createBlock(BlockType.t)).collect(Collectors.toList()));
        blocks.add(Stream.of(factory.createBlock(BlockType.t), factory.createBlock(BlockType.t), factory.createBlock(BlockType.t)).collect(Collectors.toList()));

        fillCoordinates(blocks);

        return Optional.of(blocks);
    }


    public static Optional<List<List<Block>>> complexBlocks() {
        List<List<Block>> blocks = new ArrayList<>();
        BlockFactory factory = new BlockFactory();
        blocks.add(Stream.of(factory.createBlock(BlockType.o), factory.createBlock(BlockType.o), factory.createBlock(BlockType.t), factory.createBlock(BlockType.o), factory.createBlock(BlockType.o), factory.createBlock(BlockType.o), factory.createBlock(BlockType.o), factory.createBlock(BlockType.o), factory.createBlock(BlockType.o), factory.createBlock(BlockType.o)).collect(Collectors.toList()));
        blocks.add(Stream.of(factory.createBlock(BlockType.o), factory.createBlock(BlockType.o), factory.createBlock(BlockType.o), factory.createBlock(BlockType.o), factory.createBlock(BlockType.o), factory.createBlock(BlockType.o), factory.createBlock(BlockType.o), factory.createBlock(BlockType.T), factory.createBlock(BlockType.o), factory.createBlock(BlockType.o)).collect(Collectors.toList()));
        blocks.add(Stream.of(factory.createBlock(BlockType.r), factory.createBlock(BlockType.r), factory.createBlock(BlockType.r), factory.createBlock(BlockType.o), factory.createBlock(BlockType.o), factory.createBlock(BlockType.o), factory.createBlock(BlockType.o), factory.createBlock(BlockType.T), factory.createBlock(BlockType.o), factory.createBlock(BlockType.o)).collect(Collectors.toList()));
        blocks.add(Stream.of(factory.createBlock(BlockType.r), factory.createBlock(BlockType.r), factory.createBlock(BlockType.r), factory.createBlock(BlockType.r), factory.createBlock(BlockType.o), factory.createBlock(BlockType.o), factory.createBlock(BlockType.o), factory.createBlock(BlockType.o), factory.createBlock(BlockType.o), factory.createBlock(BlockType.o)).collect(Collectors.toList()));
        blocks.add(Stream.of(factory.createBlock(BlockType.r), factory.createBlock(BlockType.r), factory.createBlock(BlockType.r), factory.createBlock(BlockType.r), factory.createBlock(BlockType.r), factory.createBlock(BlockType.t), factory.createBlock(BlockType.o), factory.createBlock(BlockType.o), factory.createBlock(BlockType.o), factory.createBlock(BlockType.o)).collect(Collectors.toList()));

        fillCoordinates(blocks);

        return Optional.of(blocks);
    }

    private static void fillCoordinates(List<List<Block>> blocks) {
        int row = 0;
        int column = 0;
        // Set Coordinates
        for (List<Block> line : blocks) {
            column = 0;
            for (Block block : line) {
                block.setCoordinate(new Coordinate(column, row));
                column++;
            }
            row++;
        }
    }
}
