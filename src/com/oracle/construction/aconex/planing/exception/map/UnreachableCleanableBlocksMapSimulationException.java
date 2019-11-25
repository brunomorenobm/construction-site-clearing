package com.oracle.construction.aconex.planing.exception.map;

public class UnreachableCleanableBlocksMapSimulationException extends MapSimulationException {

    public UnreachableCleanableBlocksMapSimulationException() {
        super("There are unreachable cleanable blocks");
    }
}
