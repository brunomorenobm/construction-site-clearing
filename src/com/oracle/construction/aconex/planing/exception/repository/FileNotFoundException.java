package com.oracle.construction.aconex.planing.exception.repository;

public class FileNotFoundException extends SimulationRepositoyException {

    public FileNotFoundException(String filePath) {
        super("File [" + filePath + "] not found");
    }
}
