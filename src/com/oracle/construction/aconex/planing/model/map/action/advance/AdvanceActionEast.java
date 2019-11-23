package com.oracle.construction.aconex.planing.model.map.action.advance;

import com.oracle.construction.aconex.planing.model.Coordinate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class AdvanceActionEast extends AdvanceAction {

    @Override
    public List<Coordinate> filterCoordinatesToClean(Integer blocksToClean, Coordinate currentPosition) {

        List<Coordinate> coordinatesToClean = new ArrayList<>();


        // Add one block because the current one is already cleaned.
        Integer currentPositionColumn = currentPosition.getColumn() + 1;
        Integer currentPositionRow = currentPosition.getRow();

        // Keep row and move right adding columns
        IntStream.range(currentPositionColumn, (currentPositionColumn + blocksToClean)).forEach(
                newColumn -> coordinatesToClean.add(new Coordinate(newColumn, currentPositionRow))
        );

        return coordinatesToClean;
    }
}
