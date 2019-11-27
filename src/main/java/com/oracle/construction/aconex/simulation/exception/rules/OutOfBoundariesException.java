package com.oracle.construction.aconex.simulation.exception.rules;

public class OutOfBoundariesException extends InterruptSimulationException {

    public OutOfBoundariesException() {
        super("You have crossed the map boundaries");
    }
}
