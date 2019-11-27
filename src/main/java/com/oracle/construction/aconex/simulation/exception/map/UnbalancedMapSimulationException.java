package com.oracle.construction.aconex.simulation.exception.map;

public class UnbalancedMapSimulationException extends MapSimulationException {

    public UnbalancedMapSimulationException() {
        super("This map is unbalanced, please correct the source map");
    }
}
