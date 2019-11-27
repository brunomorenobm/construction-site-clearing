package com.oracle.construction.aconex.simulation.exception;

public class SimulationException extends Exception {

    public SimulationException(String message) {
        super(message);
    }

    public SimulationException(Exception ex) {
        super(ex);
    }
}
