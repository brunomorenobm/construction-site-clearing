package com.oracle.construction.aconex.simulation.domain.simulation.command.action.advance;

import com.oracle.construction.aconex.simulation.domain.simulation.map.Coordinate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class NorthCommandActionAdvance extends CommandActionAdvance {

    @Override
    public List<Coordinate> createOrderedCleaningPath(Integer blocksToClean, Coordinate currentPosition) {
        List<Coordinate> coordinatesToClean = new ArrayList<>();

        Integer currentPositionColumn = currentPosition.getColumn();

        // Remove one block because the current one is already cleaned.
        Integer currentPositionRow = currentPosition.getRow() - 1;

        // Keep column and move up removing rows
        IntStream.iterate( currentPositionRow, newRow -> newRow - 1)
                .limit(blocksToClean)
                .forEach(
                    newRow -> coordinatesToClean.add(new Coordinate(currentPositionColumn, newRow))
                );

        return coordinatesToClean;
    }
}
