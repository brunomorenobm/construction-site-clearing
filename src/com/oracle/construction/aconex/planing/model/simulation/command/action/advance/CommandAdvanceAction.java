package com.oracle.construction.aconex.planing.model.simulation.command.action.advance;

import com.oracle.construction.aconex.planing.exception.SimulationException;
import com.oracle.construction.aconex.planing.exception.rules.InterruptSimulationException;
import com.oracle.construction.aconex.planing.exception.rules.OutOfBoundariesException;
import com.oracle.construction.aconex.planing.model.Context;
import com.oracle.construction.aconex.planing.model.simulation.map.Coordinate;
import com.oracle.construction.aconex.planing.model.simulation.map.block.Block;

import java.util.List;
import java.util.stream.Collectors;

public abstract class CommandAdvanceAction {


    /**
     * @param numberOfBlocksToClean
     * @param context
     * @throws InterruptSimulationException
     */
    public void execute(int numberOfBlocksToClean, Context context) throws InterruptSimulationException, SimulationException {

        // Create a ordered List of Coordinates to be cleaned
        final List<Coordinate> coordinatesToClean = createOrderedCleaningPath(numberOfBlocksToClean, context.getCurrentPosition());

        // Get the Last Coordinate
        final Coordinate lastCoordinate = coordinatesToClean.get(coordinatesToClean.size() - 1);


        List<Block> blocksToClean = null;

        // Query the Blocks to be Cleaned from map, only blocks boundary blocks wil be returned
        if (context.getBlocks() != null) {
            blocksToClean =
                    context.getBlocks().stream()
                            .flatMap(
                                    lines -> lines.stream()
                                            .filter(block -> coordinatesToClean.contains(block.getCoordinate()))

                            ).collect(Collectors.toList());
        }


        // Execute the Cleaning from all returned blocks
        if (blocksToClean != null) {

            for (Block block : blocksToClean) {
                try {
                    block.clean(context, lastCoordinate);
                } catch (InterruptSimulationException ex) {
                    context.setExecutionSuspended(true);
                    throw ex;
                }
            }
        }

        // Get the final supposed position processed by the coordinate cleaning path an check if it exists in the map
        // RULE 3: An attempt to move beyond the boundaries of the site will end the simulation even if there is uncleared land.
        if (blocksToClean.stream().filter(block -> block.getCoordinate().equals(lastCoordinate)).count() == 0) {
            throw new OutOfBoundariesException();
        }

    }


    public abstract List<Coordinate> createOrderedCleaningPath(Integer blocksToClean, Coordinate currentPosition);

}
