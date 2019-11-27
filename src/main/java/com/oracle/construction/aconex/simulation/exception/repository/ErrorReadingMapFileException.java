package com.oracle.construction.aconex.simulation.exception.repository;

public class ErrorReadingMapFileException extends SimulationRepositoyException {

    public ErrorReadingMapFileException(String filePath) {
        super("Error reading Map File [" + filePath + "]");
    }
}
