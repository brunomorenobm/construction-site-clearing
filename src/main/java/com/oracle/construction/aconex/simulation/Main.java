package com.oracle.construction.aconex.simulation;

import java.util.MissingFormatArgumentException;

public class Main {

    public static void main(String[] args) throws Exception {

        String fileSourcePath;
        if (args.length == 1) {
            fileSourcePath = args[0];
        } else {
            throw new MissingFormatArgumentException("Please inform the site-map path file");
        }

        SimulationCleaningConstructionConsole.startSimulation(fileSourcePath);
    }
}
