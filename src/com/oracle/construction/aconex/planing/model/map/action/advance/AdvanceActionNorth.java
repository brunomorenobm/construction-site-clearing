package com.oracle.construction.aconex.planing.model.map.action.advance;

import com.oracle.construction.aconex.planing.model.Coordinate;
import com.oracle.construction.aconex.planing.model.SimulationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class AdvanceActionNorth extends AdvanceAction {

    @Override
    public List<Coordinate> filterCoordinatesToClean(Integer blocksToClean, Coordinate currentPosition) {
        List<Coordinate> coordinatesToClean = new ArrayList<>();

        Integer currentPositionColumn = currentPosition.getColumn();

        // Remove one block because the current one is already cleaned.
        Integer currentPositionRow = currentPosition.getRow() - 1;

        // Keep column and move up removing rows
        IntStream.iterate( currentPositionRow, newRow -> newRow - 1)
                .limit(currentPositionRow + blocksToClean)
                .forEach(
                    newRow -> coordinatesToClean.add(new Coordinate(currentPositionColumn, newRow))
                );

        return coordinatesToClean;
    }
}
