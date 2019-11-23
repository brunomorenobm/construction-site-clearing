package com.oracle.construction.aconex.planing.model.map.action.advance;

import com.oracle.construction.aconex.planing.exception.OutOfBoundariesException;
import com.oracle.construction.aconex.planing.exception.ViolateRuleProtectedTreeException;
import com.oracle.construction.aconex.planing.model.Block;
import com.oracle.construction.aconex.planing.model.Coordinate;
import com.oracle.construction.aconex.planing.model.SimulationContext;

import java.util.List;

public abstract class AdvanceAction {


    public void execute(int blocksToClean, SimulationContext context) throws OutOfBoundariesException, ViolateRuleProtectedTreeException {


        // TODO: Validate Movement

        // TODO: Block Execution
        final List<Coordinate> coordinatesToClean = filterCoordinatesToClean(blocksToClean, context.getCurrentPosition());

        List<List<Block>> blocks = context.getBlocks();

        if (blocks != null) {
            blocks.stream()
                    .flatMap(
                            lines -> lines.stream()
                                    .filter(block -> coordinatesToClean.contains(block.getCoordinate()))

                    ).forEach(block -> block.clean(coordinatesToClean, context));
        }


    }


    public abstract List<Coordinate> filterCoordinatesToClean(Integer blocksToClean, Coordinate currentPosition);

}
