package com.oracle.construction.aconex.simulation.domain.simulation.command.action;

import com.oracle.construction.aconex.simulation.domain.mock.BlockDataGenerator;
import com.oracle.construction.aconex.simulation.domain.simulation.Context;
import com.oracle.construction.aconex.simulation.domain.simulation.SimulationContext;
import com.oracle.construction.aconex.simulation.domain.simulation.command.NavigateCommand;
import com.oracle.construction.aconex.simulation.domain.simulation.map.CardinalDirection;
import com.oracle.construction.aconex.simulation.domain.simulation.map.Coordinate;
import com.oracle.construction.aconex.simulation.domain.simulation.map.block.Block;
import com.oracle.construction.aconex.simulation.exception.rules.OutOfBoundariesException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class AdvanceCommandActionTest {

    Context context;
    CommandAction commandAction;

    @BeforeEach
    void setUp() {
        context = new SimulationContext(BlockDataGenerator.simpleBlocks().get());
        context.init();
        commandAction = new AdvanceCommandAction();
    }

    @Test
    void advanceNorth() {
        // Current Position
        context.init();
        context.setCardinalDirection(CardinalDirection.N);
        context.setCurrentPosition(new Coordinate(0,3));

        // Data to Check
        List<Coordinate> coordinatesToClean = new ArrayList<>();
        coordinatesToClean.add( new Coordinate(0,1));
        coordinatesToClean.add( new Coordinate(0,2));

        // Execute the Command
        Assertions.assertDoesNotThrow(() ->commandAction.execute(new NavigateCommand("a 2"), context));

        // Filter based on known coordinates
        List<Block> blocksToCheck = context.getBlocks().stream().flatMap(
                blocks -> blocks.stream().filter( block -> coordinatesToClean.contains(block.getCoordinate()))
        ).collect(Collectors.toList());

        // Filter based on cleaned
        List<Block> cleanedBlocks = context.getBlocks().stream().flatMap(
                blocks -> blocks.stream().filter( block -> block.getCleanedQuantity() > 0)
        ).collect(Collectors.toList());


        // Compare expected with cleaned
        Assertions.assertEquals(blocksToCheck, cleanedBlocks);
    }

    @Test
    void advanceSouth() {
        // Current Position
        context.init();
        context.setCardinalDirection(CardinalDirection.S);
        context.setCurrentPosition(new Coordinate(0,0));

        // Data to Check
        List<Coordinate> coordinatesToClean = new ArrayList<>();
        coordinatesToClean.add( new Coordinate(0,1));
        coordinatesToClean.add( new Coordinate(0,2));

        // Execute the Command
        Assertions.assertDoesNotThrow(() ->commandAction.execute(new NavigateCommand("a 2"), context));

        // Filter based on known coordinates
        List<Block> blocksToCheck = context.getBlocks().stream().flatMap(
                blocks -> blocks.stream().filter( block -> coordinatesToClean.contains(block.getCoordinate()))
        ).collect(Collectors.toList());

        // Filter based on cleaned
        List<Block> cleanedBlocks = context.getBlocks().stream().flatMap(
                blocks -> blocks.stream().filter( block -> block.getCleanedQuantity() > 0)
        ).collect(Collectors.toList());


        // Compare expected with cleaned
        Assertions.assertEquals(blocksToCheck, cleanedBlocks);

    }

    @Test
    void advanceEast() {

        // Current Position
        context.setCardinalDirection(CardinalDirection.E);
        context.setCurrentPosition(new Coordinate(-1,0));

        // Data to Check
        List<Coordinate> coordinatesToClean = new ArrayList<>();
        coordinatesToClean.add(new Coordinate(0,0));
        coordinatesToClean.add( new Coordinate(1,0));

        // Execute the Command
        Assertions.assertDoesNotThrow(() ->commandAction.execute(new NavigateCommand("a 2"), context));

        // Filter based on known coordinates
        List<Block> blocksToCheck = context.getBlocks().stream().flatMap(
                blocks -> blocks.stream().filter( block -> coordinatesToClean.contains(block.getCoordinate()))
        ).collect(Collectors.toList());

        // Filter based on cleaned
        List<Block> cleanedBlocks = context.getBlocks().stream().flatMap(
                blocks -> blocks.stream().filter( block -> block.getCleanedQuantity() > 0)
        ).collect(Collectors.toList());


        // Compare expected with cleaned
        Assertions.assertEquals(blocksToCheck, cleanedBlocks);
    }

    @Test
    void advanceWest() {

        // Current Position
        context.setCardinalDirection(CardinalDirection.W);
        context.setCurrentPosition(new Coordinate(2,0));

        // Data to Check
        List<Coordinate> coordinatesToClean = new ArrayList<>();
        coordinatesToClean.add(new Coordinate(0,0));
        coordinatesToClean.add( new Coordinate(1,0));

        // Execute the Command
        Assertions.assertDoesNotThrow(() ->commandAction.execute(new NavigateCommand("a 2"), context));

        // Filter based on known coordinates
        List<Block> blocksToCheck = context.getBlocks().stream().flatMap(
                blocks -> blocks.stream().filter( block -> coordinatesToClean.contains(block.getCoordinate()))
        ).collect(Collectors.toList());

        // Filter based on cleaned
        List<Block> cleanedBlocks = context.getBlocks().stream().flatMap(
                blocks -> blocks.stream().filter( block -> block.getCleanedQuantity() > 0)
        ).collect(Collectors.toList());


        // Compare expected with cleaned
        Assertions.assertEquals(blocksToCheck, cleanedBlocks);
    }

    @Test
    void advanceOutOfBoundaries() {
        // Current Position
        context.setCardinalDirection(CardinalDirection.W);
        context.setCurrentPosition(new Coordinate(2,0));

        // Execute the Command
        Assertions.assertThrows(OutOfBoundariesException.class,() ->commandAction.execute(new NavigateCommand("a 20"), context));
    }

}