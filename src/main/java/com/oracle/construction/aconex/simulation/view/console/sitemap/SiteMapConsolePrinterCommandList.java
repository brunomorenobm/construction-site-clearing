package com.oracle.construction.aconex.simulation.view.console.sitemap;

import com.oracle.construction.aconex.simulation.domain.simulation.command.CommandActionType;
import com.oracle.construction.aconex.simulation.domain.simulation.map.Simulation;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.stream.Collectors;

public class SiteMapConsolePrinterCommandList implements SiteMapConsolePrinter {

    public void print(Simulation simulation, PrintStream out) {
        String strCommands = Arrays.stream(CommandActionType.values()).map(command -> command.getCommandDisplay())
                .collect(Collectors.joining(", "));
        out.println(strCommands);
    }
}
