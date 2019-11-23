package com.oracle.construction.aconex.planing.model.map.action.advance;

import com.oracle.construction.aconex.planing.model.Coordinate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class AdvanceActionWest extends AdvanceAction {


    @Override
    public List<Coordinate> filterCoordinatesToClean(Integer blocksToClean, Coordinate currentPosition) {
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
