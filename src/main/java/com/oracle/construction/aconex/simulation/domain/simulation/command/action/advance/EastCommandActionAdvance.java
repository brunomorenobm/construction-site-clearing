package com.oracle.construction.aconex.simulation.domain.simulation.command.action.advance;

import com.oracle.construction.aconex.simulation.domain.simulation.map.Coordinate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class EastCommandActionAdvance extends CommandActionAdvance {

    @Override
    public List<Coordinate> createOrderedCleaningPath(Integer blocksToClean, Coordinate currentPosition) {

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
