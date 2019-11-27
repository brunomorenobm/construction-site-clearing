package com.oracle.construction.aconex.simulation.view.console.sitemap;

import com.oracle.construction.aconex.simulation.domain.simulation.map.Simulation;

import java.io.PrintStream;
import java.util.stream.Collectors;

public class SiteMapConsolePrinterExecutedCommands implements SiteMapConsolePrinter {

    public void print(Simulation simulation, PrintStream out) {
        String strCommands = simulation.getExecutedCommands().stream().map(command -> command.toString())
                .collect(Collectors.joining(", "));
        out.println(strCommands);
    }
}
