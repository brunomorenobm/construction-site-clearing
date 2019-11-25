package com.oracle.construction.aconex.planing.view.console.sitemap;

import com.oracle.construction.aconex.planing.domain.simulation.command.CommandActionType;
import com.oracle.construction.aconex.planing.domain.simulation.map.SiteMap;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.stream.Collectors;

public class SiteMapConsolePrinterCommandList implements SiteMapConsolePrinter {

    public void print(SiteMap siteMap, PrintStream out) {
        String strCommands = Arrays.stream(CommandActionType.values()).map(command -> command.getCommandDisplay())
                .collect(Collectors.joining(", "));
        out.println(strCommands);
    }
}
