package com.oracle.construction.aconex.planing.exception.map;

public class UnbalancedMapSimulationException extends MapSimulationException {

    public UnbalancedMapSimulationException() {
        super("This map is unbalanced, please correct the source map");
    }
}
