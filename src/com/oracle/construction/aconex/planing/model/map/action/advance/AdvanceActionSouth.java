package com.oracle.construction.aconex.planing.model.map.action.advance;

import com.oracle.construction.aconex.planing.model.Coordinate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class AdvanceActionSouth extends AdvanceAction {

    @Override
    public List<Coordinate> filterCoordinatesToClean(Integer blocksToClean, Coordinate currentPosition) {
        List<Coordinate> coordinatesToClean = new ArrayList<>();


        Integer currentPositionColumn = currentPosition.getColumn();

        // Add one block because the current one is already cleaned.
        Integer currentPositionRow = currentPosition.getRow() + 1;

        // Keep column and move down removing rows
        IntStream.range(currentPositionRow, (currentPositionRow + blocksToClean)).forEach(
                newRow -> coordinatesToClean.add(new Coordinate(currentPositionColumn, newRow))
        );

        return coordinatesToClean;
    }
}
