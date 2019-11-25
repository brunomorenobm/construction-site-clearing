package com.oracle.construction.aconex.planing.model.simulation.command.action.advance;

import com.oracle.construction.aconex.planing.model.simulation.map.Coordinate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class CommandAdvanceActionWest extends CommandAdvanceAction {


    @Override
    public List<Coordinate> createOrderedCleaningPath(Integer blocksToClean, Coordinate currentPosition) {
        List<Coordinate> coordinatesToClean = new ArrayList<>();

        // Remove one block because the current one is already cleaned.
        Integer currentPositionColumn = currentPosition.getColumn() - 1;
        Integer currentPositionRow = currentPosition.getRow();

        // Keep row and move left removing columns
        IntStream.iterate( currentPositionColumn, newColumn -> newColumn - 1)
                .limit(currentPositionColumn + blocksToClean)
                .forEach(
                        newColumn -> coordinatesToClean.add(new Coordinate(newColumn, currentPositionRow))
                );

        return coordinatesToClean;
    }
}