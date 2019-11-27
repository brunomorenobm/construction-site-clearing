package com.oracle.construction.aconex.simulation.exception.map;

public class UnreachableCleanableBlocksMapSimulationException extends MapSimulationException {

    public UnreachableCleanableBlocksMapSimulationException() {
        super("There are unreachable cleanable blocks");
    }
}
